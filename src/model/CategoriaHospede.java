package model;

public enum CategoriaHospede {
    NORMAL(0.0),
    VIP(0.15),
    PREMIUM(0.35);

    private Double desconto;

    private CategoriaHospede(Double desconto){
        this.desconto = desconto;
    }
}
