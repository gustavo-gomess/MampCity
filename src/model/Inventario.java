package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Inventario extends Entity{

    private String item;
    private String descricao;
    private Integer quantidade;

    public Inventario(String item, String descricao, Integer quantidade) {
        this.item = item;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
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
                "item='" + item + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
