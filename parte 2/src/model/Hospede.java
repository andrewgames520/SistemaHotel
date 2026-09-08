package model;

public class Hospede {
	private String nome;
	private String cpf;
	private TipoHospede tipo;
	
	public Hospede(String nome, String cpf, TipoHospede tipo) {
		this.nome = nome;
		this.cpf = cpf;
		this.tipo = tipo;
	}
	
	
	public Hospede(String nome) {
		this.nome = nome;
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return "Hóspede: " + nome + " - CPF: " + cpf;
	}
	
	public void setTipoHospede(TipoHospede tipo) {
		this.tipo = tipo;
	}
	
	
}
