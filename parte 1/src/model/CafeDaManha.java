package model;

public class CafeDaManha implements ServicoHotel {
    private String data;
    private Double custo;
    private Pagamento pagamento;
    @Override
    public Double CalcularPreco() {
        return custo*1.20;
    }
}
