package model;

public abstract class Pagamento {
    private String nome;
    private String dataPagamento;
    private Double valor;

    public Pagamento(String nome, String dataPagamento, Double valor) {
        this.nome = nome;
        this.dataPagamento = dataPagamento;
        this.valor = valor;
    }

    public abstract void processar();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
