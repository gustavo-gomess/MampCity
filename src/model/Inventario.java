package model;

public class Inventario extends Entity{

    private String item;
    private String descricaoInv;
    private Integer quantidade;

    public Inventario(String item,
                      String descricaoInv,
                      Integer quantidade) {
        this.item = item;
        this.descricaoInv = descricaoInv;
        this.quantidade = quantidade;
    }
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescricaoInv() {
        return descricaoInv;
    }

    public void setDescricaoInv(String descricaoInv) {
        this.descricaoInv = descricaoInv;
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
                ", descricaoInv='" + descricaoInv + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
