package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Inventario extends Entity{

    private String Item;
    private String descricao;
    private Integer quantidade;

    public Inventario(String item, String descricao, Integer quantidade) {
        Item = item;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public Inventario(String item, Integer quantidade) {
        Item = item;
        this.quantidade = quantidade;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "Item='" + Item + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
