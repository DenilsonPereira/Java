package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import dto.HotelDTO;

public class HotelDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/hotel";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "";

    private Connection connection;

    public HotelDAO() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); 
        }
    }

    public void salvarHotel(HotelDTO hotel) throws SQLException {
        String sql = "INSERT INTO hotel (nome, cep, logradouro, cidade, estado) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, hotel.getNome());
            statement.setString(2, hotel.getCep());
            statement.setString(3, hotel.getLogradouro());
            statement.setString(4, hotel.getCidade());
            statement.setString(5, hotel.getEstado());

            statement.executeUpdate();
            
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                hotel.setCodigoHotel(generatedKeys.getInt(1));
            }
        }
    }

    public List<HotelDTO> listarHoteis() throws SQLException {
        List<HotelDTO> hoteis = new ArrayList<>();
        String sql = "SELECT * FROM hotel";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                HotelDTO hotel = new HotelDTO();
                hotel.setCodigoHotel(resultSet.getInt("codigo_hotel"));
                hotel.setNome(resultSet.getString("nome"));
                hotel.setCep(resultSet.getString("cep"));
                hotel.setLogradouro(resultSet.getString("logradouro"));
                hotel.setCidade(resultSet.getString("cidade"));
                hotel.setEstado(resultSet.getString("estado"));

                hoteis.add(hotel);
            }
        }
        return hoteis;
    }

    public void atualizarHotel(HotelDTO hotel) throws SQLException {
        String sql = "UPDATE hotel SET nome=?, cep=?, logradouro=?, cidade=?, estado=? WHERE codigo_hotel=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, hotel.getNome());
            statement.setString(2, hotel.getCep());
            statement.setString(3, hotel.getLogradouro());
            statement.setString(4, hotel.getCidade());
            statement.setString(5, hotel.getEstado());
            statement.setInt(6, hotel.getCodigoHotel());

            statement.executeUpdate();
        }
    }

    public void deletarHotel(int codigoHotel) throws SQLException {
        String sql = "DELETE FROM hotel WHERE codigo_hotel=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, codigoHotel);

            statement.executeUpdate();
        }
    }
    
    public void removerTodos() throws SQLException {
        String sql = "DELETE FROM hotel";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        }
    }
    
    public Optional<HotelDTO> buscarHotelPorCodigo(int codigoHotel) throws SQLException {
        String sql = "SELECT * FROM hotel WHERE codigo_hotel = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, codigoHotel);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                HotelDTO hotel = new HotelDTO();
                hotel.setNome(rs.getString("nome"));
                hotel.setCep(rs.getString("cep"));
                hotel.setLogradouro(rs.getString("logradouro"));
                hotel.setCidade(rs.getString("cidade"));
                hotel.setEstado(rs.getString("estado"));
                hotel.setCodigoHotel(rs.getInt("codigo_hotel"));
                return Optional.of(hotel);
            }
        } catch (SQLException e) {
            throw e;
        }
        return Optional.empty();
    }

    public void fecharConexao() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}