package model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos = new ArrayList<>();

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void adicionarQuarto(Quarto quarto){
        this.quartos.add(quarto);
    }

    public void adicionarQuarto(int numero,double valor, Tipo tipo, Disponibilidade disponibilidade){
        Quarto q = new Quarto(numero,valor,tipo,disponibilidade);
        this.quartos.add(q);
    }

    public void exibirQuartos(){
        for (Quarto q: this.quartos) {
            System.out.println(q);
        }
    }

    public void removerQuarto(int numero){
        this.quartos.removeIf(q -> q.getNumero()==numero);
    }

    public void mediaQuartos(){
        double soma = 0;
        for (Quarto q: this.quartos){
            soma += q.getValorDiaria();
        }
        double media = soma/this.quartos.size();
        System.out.println("Media das diarias: " + media);
    }
}
