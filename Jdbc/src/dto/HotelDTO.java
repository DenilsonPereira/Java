package dto;

public class HotelDTO {
    private Integer codigoHotel;
    private String nome;
    private String cep;
    private String logradouro;
    private String cidade;
    private String estado;

    // Construtores

    public HotelDTO() {
    }

    public HotelDTO(Integer codigoHotel, String nome, String cep, String logradouro, String cidade, String estado) {
        this.codigoHotel = codigoHotel;
        this.nome = nome;
        this.cep = cep;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
    }

    // Getters e Setters

    public int getCodigoHotel() {
        return codigoHotel;
    }

    public void setCodigoHotel(Integer codigoHotel) {
        this.codigoHotel = codigoHotel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Hotel {" +
                "codigo='" + getCodigoHotel() + '\'' +
                ", nome='" + getNome() + '\'' +
                ", cep='" + getCep() + '\'' +
                ", logradouro='" + getLogradouro() + '\'' +
                ", cidade='" + getCidade() + '\'' +
                ", estado='" + getEstado() + '\'' +
                '}';
    }
}
