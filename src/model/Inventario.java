package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Inventario {

    private LocalDate dataCompra;
    private Item tipoItem;
    private String descrição;
    private Integer quantidade;
    private BigDecimal valor;
    private LocalDate dataBaixa;

    public Inventario(LocalDate dataCompra, Item tipoItem, String descrição, Integer quantidade, BigDecimal valor, LocalDate dataBaixa) {
        this.dataCompra = dataCompra;
        this.tipoItem = tipoItem;
        this.descrição = descrição;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataBaixa = dataBaixa;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public void setTipoItem(Item tipoItem) {
        this.tipoItem = tipoItem;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
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

    public Item getTipoItem() {
        return tipoItem;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "dataCompra=" + dataCompra +
                ", tipoItem=" + tipoItem +
                ", descrição='" + descrição + '\'' +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                ", dataBaixa=" + dataBaixa +
                '}';
    }
}
