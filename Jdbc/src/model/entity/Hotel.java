package model.entity;

public class Hotel {
	
	private long codigo;
	private String nome;
	private String cep;
	private String logradouro;
	private String cidade;
	private String estado;
	
	public Hotel() {
	}
	
	public Hotel(String nome, String cep, String logradouro, String cidade, String estado) {
		this.nome = nome;
		this.cep = cep;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Hotel(long codigo, String nome, String cep, String logradouro, String cidade, String estado) {
		this.codigo = codigo;
		this.nome = nome;
		this.cep = cep;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hotel [codigo=" + codigo + ", nome=" + nome + ", cep=" + cep + ", logradouro=" + logradouro
				+ ", cidade=" + cidade + ", estado=" + estado + "]";
	}
}