package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import dao.HotelDAO;
import dto.HotelDTO;

public class HotelService {

	private HotelDAO dao;
	
	public HotelService() throws ClassNotFoundException {
		this.dao = new HotelDAO();
	}
	
	public boolean salvarHotel(HotelDTO hotel) {
		try {
			dao.salvarHotel(hotel);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public List<HotelDTO> listarHoteis() {
		try {
			return dao.listarHoteis();
		} catch (SQLException e) {
			return null;
		}
	}

	public Optional<HotelDTO> buscarHotelPorCodigo(int codigoHotel) {
        try {
            return dao.buscarHotelPorCodigo(codigoHotel);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

	public boolean atualizarHotel(int codigoHotel, HotelDTO hotelAtualizado) {
	    Optional<HotelDTO> hotelExistente = buscarHotelPorCodigo(codigoHotel);
	    if (hotelExistente.isPresent()) {
	        HotelDTO hotelExistenteDTO = hotelExistente.get();

	        
	        if (hotelAtualizado.getNome() != null) {
	            hotelExistenteDTO.setNome(hotelAtualizado.getNome());
	        }
	        if (hotelAtualizado.getCep() != null) {
	            hotelExistenteDTO.setCep(hotelAtualizado.getCep());
	        }
	        if (hotelAtualizado.getLogradouro() != null) {
	            hotelExistenteDTO.setLogradouro(hotelAtualizado.getLogradouro());
	        }
	        if (hotelAtualizado.getCidade() != null) {
	            hotelExistenteDTO.setCidade(hotelAtualizado.getCidade());
	        }
	        if (hotelAtualizado.getEstado() != null) {
	            hotelExistenteDTO.setEstado(hotelAtualizado.getEstado());
	        }

	        try {
	            dao.atualizarHotel(hotelExistenteDTO);
	            System.out.println("Hotel atualizado com sucesso!");
	            return true;
	        } catch (SQLException e) {
	            System.out.println("Erro ao atualizar hotel: " + e.getMessage());
	            return false;
	        }
	    } else {
	        System.out.println("Hotel com código " + codigoHotel + " não encontrado.");
	        return false;
	    }
	}



	public boolean removerHotel(int codigoHotel) {
	    Optional<HotelDTO> hotelExistente = buscarHotelPorCodigo(codigoHotel);
	    if (hotelExistente.isPresent()) {
	        try {
	            dao.deletarHotel(codigoHotel);
	            System.out.println("Hotel removido com sucesso!");
	            return true;
	        } catch (SQLException e) {
	            System.out.println("Erro ao remover hotel: " + e.getMessage());
	            return false;
	        }
	    } else {
	        System.out.println("Hotel com código " + codigoHotel + " não encontrado.");
	        return false;
	    }
	}

    
	public void removerTodos() {
        try {
            dao.removerTodos(); 
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }

}
