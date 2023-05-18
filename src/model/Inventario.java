package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Inventario {

    private LocalDate dataCompra;
    private Item tipoItem;
    private String descrição;
    private BigDecimal valor;
    private Local localAlocado;
    private LocalDate dataBaixa;
    private Funcionario usuario;

    public Inventario(LocalDate dataCompra, Item tipoItem, String descrição,
                      BigDecimal valor, Local localAlocado, LocalDate dataBaixa, Funcionario usuario) {
        this.dataCompra = dataCompra;
        this.tipoItem = tipoItem;
        this.descrição = descrição;
        this.valor = valor;
        this.localAlocado = localAlocado;
        this.dataBaixa = dataBaixa;
        this.usuario = usuario;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public Item getTipoItem() {
        return tipoItem;
    }

    public String getDescrição() {
        return descrição;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Local getLocalAlocado() {
        return localAlocado;
    }

    public LocalDate getDataBaixa() {
        return dataBaixa;
    }

    public Funcionario getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "dataCompra=" + dataCompra +
                ", tipoItem=" + tipoItem +
                ", descrição='" + descrição + '\'' +
                ", valor=" + valor +
                ", localAlocado=" + localAlocado +
                ", dataBaixa=" + dataBaixa +
                ", usuario=" + usuario +
                '}';
    }
}
