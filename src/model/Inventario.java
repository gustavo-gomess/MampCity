package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Inventario {
    private Integer quantidade;
    private BigDecimal valor;

    public Inventario( Integer quantidade, BigDecimal valor) {
        this.quantidade = quantidade;
        this.valor = valor;
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

    @Override
    public String toString() {
        return "Inventario{" +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                '}';
    }
}
