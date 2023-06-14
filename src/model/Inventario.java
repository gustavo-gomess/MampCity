package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Inventario extends Entity{

    private Item item;
    private Integer quantidade;
    private BigDecimal valor;

    public Inventario(Item item, Integer quantidade, BigDecimal valor) {
        this.item = item;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                '}';
    }
}
