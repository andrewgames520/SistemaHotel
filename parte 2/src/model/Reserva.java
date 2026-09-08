package model;

public class Reserva {
	private Quarto quarto;
	private Hospede hospede;
	private StatusReserva status;
	private FormaPagamento formaPagamento;
	
	public Reserva(Quarto quarto, 
					Hospede hospede, 
					StatusReserva status,
					FormaPagamento formaPagamento) {
		this.quarto = quarto;
		this.hospede = hospede;
		this.status = status;
		this.formaPagamento = formaPagamento;
	}

	@Override
	public String toString() {
		return "Quarto: " + quarto + ", hospede: " + hospede;
	}
	
	
	
	
	
}
