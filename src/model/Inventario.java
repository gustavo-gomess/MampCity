package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Inventario {
    private LocalDate dataCompra;
    private Integer quantidade;
    private BigDecimal valor;
    private LocalDate dataBaixa;

    public Inventario(LocalDate dataCompra, Integer quantidade, BigDecimal valor, LocalDate dataBaixa) {
        this.dataCompra = dataCompra;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataBaixa = dataBaixa;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setDataBaixa(LocalDate dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "dataCompra=" + dataCompra +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                ", dataBaixa=" + dataBaixa +
                '}';
    }
}
