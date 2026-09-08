package app;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import model.Disponibilidade;
import model.FormaPagamento;
import model.Hospede;
import model.Hotel;
import model.Quarto;
import model.Reserva;
import model.StatusReserva;
import model.Tipo;
import model.TipoHospede;
import utils.ComparadorPorNumero;
import utils.ComparadorPorPreco;
import utils.FiltroPorDisponibilidade;

public class Main {

	public static void main(String[] args) {
		Quarto q1 = new Quarto(
				101,
				180.0,
				Tipo.SIMPLES,
				Disponibilidade.DISPONIVEL
		);

		Quarto q2 = new Quarto(
				102,
				110.0,
				Tipo.DUPLO,
				Disponibilidade.OCUPADO
		);

		Quarto q3 = new Quarto(
				103,
				500.0,
				Tipo.COBERTURA,
				Disponibilidade.DISPONIVEL
		);

		Hotel hotel = new Hotel();

		hotel.adicionarQuarto(q1);
		hotel.adicionarQuarto(q2);
		hotel.adicionarQuarto(q3);

		Tipo t = Tipo.DUPLO;

		for (Quarto q : hotel.filtrar(q -> q.getTipo() == t && q.getValorDiaria() < 200.0)) {
			System.out.println(q);
		}
		//exercicio 1
		System.out.println("\nExercicio 1");
		Predicate<Quarto> estaDisponivel = q -> q.getDisponibilidade() == Disponibilidade.DISPONIVEL;
		System.out.println(estaDisponivel.test(q3));

		//exercicio 2
		System.out.println("\nExercicio 2");
		Predicate<Quarto> diariaBarata = q -> q.getValorDiaria() < 200.0;
		System.out.println(diariaBarata.test(q3));

		//exercicio 3
		System.out.println("\nExercicio 3");
		for (Quarto q : hotel.getQuartos()) {
			if (estaDisponivel.test(q)) {
				System.out.println(q);
			}
		}
		//exercicio 4
		System.out.println("\nExercicio 4");

		Predicate<Quarto> disponivelEbarato = estaDisponivel.and(diariaBarata);
		Predicate<Quarto> disponivelOubarato = estaDisponivel.or(diariaBarata);
		//System.out.println(disponivelEbarato.test(q3));
		System.out.println("Barato e disponivel");
		hotel.getQuartos().stream().filter(disponivelEbarato).forEach(System.out::println);
		System.out.println("Barato ou disponivel");
		hotel.getQuartos().stream().filter(disponivelOubarato).forEach((System.out::println));

		//exercicio 5
		System.out.println("\nExercicio 5");
		Function<Quarto, Integer> obterNumero = Quarto::getNumero;
		System.out.println(obterNumero.apply(q1));

		//exercicio 6
		System.out.println("\nExercicio 6");
		Function<Quarto, Double> obterValorDiaria = Quarto::getValorDiaria;
		for (Quarto q : hotel.getQuartos()) {
			System.out.println(obterValorDiaria.apply(q));
		}

		//exercicio 7
		System.out.println("\nExercicio 7");
		Function<Quarto, String> descricaoQuarto = q -> "Quarto " + q.getNumero() + " - Diária: R$ " + q.getValorDiaria();
		System.out.println(descricaoQuarto.apply(q1));

		//exercicio 8
		System.out.println("\nExercicio 8");
		Function<Quarto, Double> valorTresDiarias = q -> q.getValorDiaria() * 3;
		System.out.println(q1);
		System.out.println("3 diárias = R$:" + valorTresDiarias.apply(q1));

		//desafio
		Function<Quarto, Double> valorTresDiariasTaxa = q -> valorTresDiarias.apply(q) * 1.10;
		System.out.println("3 diárias com taxa de 10% = R$:" + valorTresDiariasTaxa.apply(q1));

		//exercicio 9
		System.out.println("\nExercicio 9");
		hotel.getQuartos().stream().filter(estaDisponivel).forEach(q -> System.out.println(descricaoQuarto.apply(q)));

		//exercicio 10
		System.out.println("\nExercicio 10");

		System.out.println("\nConsulta A");
		hotel.filtrar(estaDisponivel).forEach(System.out::println);

		System.out.println("\nConsulta B");
		hotel.filtrar(q -> q.getValorDiaria() < 300).forEach(System.out::println);

		System.out.println("\nConsulta C");
		hotel.filtrar(q -> q.getValorDiaria() > 150).forEach(System.out::println);

		//exercicio 11
		System.out.println("\nExercicio 11");
		System.out.println("A. Uma lista de números");
		hotel.transformar(Quarto::getNumero).forEach(System.out::println);

		System.out.println("\nB. Uma lista de valores");
		hotel.transformar(Quarto::getValorDiaria).forEach(System.out::println);

		System.out.println("\nC. Uma lista de descrições");
		hotel.transformar(Quarto::toString).forEach(System.out::println);

		//exercicio 12
		System.out.println("\nExercicio 12");
		Predicate<Quarto> ate300 = q -> q.getValorDiaria() < 300;
		Predicate<Quarto> criterio= estaDisponivel.and(ate300);
		List<Quarto> filtrar = hotel.filtrar(criterio);
		Function<Quarto, String> formatar = q-> String.format("Quarto %d disponível por R$ %.2f",q.getNumero(),q.getValorDiaria());
		hotel.transformar(formatar).forEach(System.out::println);
	}

}
