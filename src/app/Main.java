package app;

import model.*;
import utils.ComparadorPorPreco;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /*
        List<String> hospedes = new ArrayList<>();
        String nome;
        for (int i = 0; i < 5; i++) {
            nome = scan.nextLine();
            hospedes.add(nome);
        }
         */
        Hospede hospede1 = new Hospede("Carlos Silva");
        Hospede hospede2 = new Hospede("Ana Oliveira");
        Hospede hospede3 = new Hospede("Marcos Santos");
        Hospede hospede4 = new Hospede("Juliana Costa");

        List<Hospede> hospedes = new ArrayList<>();
        hospedes.add(hospede1);
        hospedes.add(hospede2);
        hospedes.add(hospede3);
        hospedes.add(hospede4);

        Quarto q1 = new Quarto(101, 180.0, Tipo.SIMPLES, Disponibilidade.DISPONIVEL);
        Quarto q2 = new Quarto(102, 110.0, Tipo.DUPLO, Disponibilidade.OCUPADO);
        Quarto q3 = new Quarto(103, 500.0, Tipo.COBERTURA, Disponibilidade.DISPONIVEL);
        Quarto q4 = new Quarto(104, 300.0, Tipo.SUITE, Disponibilidade.OCUPADO);
        Quarto q5 = new Quarto(105, 850.0, Tipo.SUPER_PREMIUM, Disponibilidade.DISPONIVEL);

        Hotel hotel = new Hotel();

        hotel.adicionarQuarto(q3);
        hotel.adicionarQuarto(q5);
        hotel.adicionarQuarto(q2);
        hotel.adicionarQuarto(q1);
        hotel.adicionarQuarto(q4);
        /*
        //cadastra 3 quartos
        for (int i = 0; i < 3; i++) {
            cadastrarQuarto(scan,hotel);
        }
        */
        //exibe o numero de todos os quartos
        System.out.println("Lista antes da remoção");
        hotel.exibirQuartos();
        hotel.removerQuarto(103);
        System.out.println();
        System.out.println("Lista depois da remoção");
        hotel.exibirQuartos();

        /*
        hotel.getQuartos().sort((judas, tome) ->
                Double.compare(judas.getValorDiaria(),
                        tome.getValorDiaria()));
        */
        //ordena os quartos por numero
        System.out.println();
        System.out.println("Quartos ordenados por numero usando função lambda");
        hotel.getQuartos().sort((n1,n2) ->
                Integer.compare(n1.getNumero(), n2.getNumero())
                );
        hotel.exibirQuartos();
        System.out.println();
        System.out.println("Quartos ordenados por numero");
        hotel.getQuartos().sort( new ComparadorPorNumero());
        hotel.exibirQuartos();
        System.out.println();
        System.out.println("Quartos ordenados por valor");
        hotel.getQuartos().sort(new ComparadorPorPreco());
        hotel.getQuartos().forEach(System.out::println);
        // exibe a media das diarias
        System.out.println();
        hotel.mediaQuartos();
        System.out.println();

        Set<String> servicos = new HashSet<>();
        servicos.add("Wi-fi");
        servicos.add("Psicna");
        servicos.add("Academia");
        servicos.add("Wi-fi");
        //wi-fi sera adicionado apenas uma vez

        /*
        //associar o numero do quarto a cada hospede
        Map<Integer, String> locacao= new HashMap<>();
        for(int i = 0; i < hotel.getQuartos().size(); i++) {
            locacao.put(hotel.getQuartos().get(i).getNumero(), hospedes.get(i).getNome());
        }
        System.out.println(locacao);
         */

        Map<Integer, Quarto> locacao = new HashMap<>();
        for(int i = 0; i < hotel.getQuartos().size(); i++) {
            locacao.put(hotel.getQuartos().get(i).getNumero(), hotel.getQuartos().get(i));
        }
        //acha o quarto vinculado a chave e mostra suas informaçoes
        Integer busca = 105;
//        for (Quarto q : hotel.getQuartos()) {
//            if (locacao.get(q.getNumero()).equals(busca)) {}
//        }
        Quarto achado = locacao.get(busca);
        System.out.printf("Numero do quarto: %d%nTipo: %s%nDisponibilidade: %s%n%n",achado.getNumero(),achado.getTipo(),achado.getDisponibilidade());

        Reserva reserva = new Reserva(StatusReserva.PENDENTE);
        reserva.toString();
    }


    public static Hotel cadastrarQuarto(Scanner scan,Hotel hotel){
        System.out.println("Qual numero do quarto");
        Integer num = scan.nextInt();
        System.out.println("Qual valor da diária");
        Double valor = scan.nextDouble();
        System.out.println("Qual tipo do quarto");
        scan.nextLine();
        String sTipo = scan.nextLine();
        Tipo tipo =  Tipo.valueOf(sTipo.toUpperCase());
        System.out.println("Qual a disponibilidade do quarto");
        String sDisponivel = scan.nextLine();
        Disponibilidade disponibilidade = Disponibilidade.valueOf(sDisponivel.toUpperCase());
        hotel.adicionarQuarto(num,valor,tipo,disponibilidade);
        return hotel;
    }

}