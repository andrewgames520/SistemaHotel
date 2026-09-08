package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Hotel {
	private List<Quarto> quartos;
	private List<Reserva> reservas;

	public Hotel() {
		this.quartos = new ArrayList<Quarto>();
		this.reservas = new ArrayList<Reserva>();
	}

	public List<Quarto> getQuartos() {
		return quartos;
	}

	public void adicionarQuarto(int numero,
	                            double valorDiaria,
	                            Tipo tipo,
	                            Disponibilidade disponibilidade) {

		Quarto quarto = new Quarto(numero,
				valorDiaria,
				tipo,
				disponibilidade);
		this.quartos.add(quarto);
	}

	public void adicionarQuarto(Quarto quarto) {
		this.quartos.add(quarto);
	}

	public void listarQuartos() {
		for (Quarto q : this.quartos) {
			System.out.println(q.toString());
		}
	}

	public List<Quarto>
	filtrar(Predicate<Quarto> criterio) {

		List<Quarto> resultado = new ArrayList<Quarto>();
		for (Quarto q : this.quartos) {
			if (criterio.test(q)) {
				resultado.add(q);
			}
		}

		return quartos.stream().filter(criterio).toList();
	}

	public <amarelinha> List<amarelinha> transformar(Function<Quarto, amarelinha> funcao){
		List<amarelinha> resultado = new ArrayList<>();
		this.quartos.stream().forEach(q -> resultado.add(funcao.apply(q)));
		return resultado;
	}

}
