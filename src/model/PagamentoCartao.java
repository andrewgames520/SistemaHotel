package model;

public class PagamentoCartao extends Pagamento {
    private Integer numCartao;

    public PagamentoCartao(String nome, String dataPagamento, Double valor, Integer numCartao) {
        super(nome, dataPagamento, valor);
        this.numCartao = numCartao;
    }

    @Override
    public void processar(){
        System.out.printf("Nome do pagante: %s\nValor pago: %f\nData do pagamento: %s",this.getNome(),this.getValor(),this.getDataPagamento());

    }

    public Integer getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(Integer numCartao) {
        this.numCartao = numCartao;
    }
}
