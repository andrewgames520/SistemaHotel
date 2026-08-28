package model;

public enum Tipo {
    SIMPLES(1),
    DUPLO(2),
    SUITE(4),
    COBERTURA(2),
    SUPER_PREMIUM(4);

    private int capacidade;

    private Tipo(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getCapacidade() {
        return this.capacidade;
    }
}
