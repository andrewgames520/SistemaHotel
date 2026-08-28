package model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;

    public Hotel() {
        this.quartos = new ArrayList<Quarto>();
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
    public void removerQuarto(int numero){
        for(int i = 0; i < quartos.size(); i++){
            if(quartos.get(i).getNumero() == numero){
                quartos.remove(i);
            }
        }
    }
    public void exibirQuartos(){
        for(Quarto q : this.getQuartos()) {
            System.out.println(q);
        }
    }
    public void mediaQuartos(){
        Double soma = 0.0;
        for(Quarto q : this.getQuartos()) {
            soma += q.getValorDiaria();
        }
        System.out.println("Valor médio das diárias:" + soma/this.getQuartos().size());
    }
}
