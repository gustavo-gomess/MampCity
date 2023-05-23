package model;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Produto {


    private LocalDate dataCompra;
    private String descricao;
    private BigDecimal valorProduto;
    private Local localAlocado;
    private LocalDate dataBaixa;
    private Funcionario funcionario;


    public Produto(LocalDate dataCompra, String descricao, BigDecimal valorProduto, Local localAlocado, LocalDate dataBaixa, Funcionario funcionario) {
        this.dataCompra = dataCompra;
        this.descricao = descricao;
        this.valorProduto = valorProduto;
        this.localAlocado = localAlocado;
        this.dataBaixa = dataBaixa;
        this.funcionario = funcionario;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }

    public LocalDate getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(LocalDate dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "dataCompra=" + dataCompra +
                ", descricao='" + descricao + '\'' +
                ", valorProduto=" + valorProduto +
                ", localAlocado=" + localAlocado +
                ", dataBaixa=" + dataBaixa +
                ", funcionario=" + funcionario +
                '}';
    }
}
