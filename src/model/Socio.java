package model;

import java.math.BigDecimal;
import java.util.List;

public class Socio extends Pessoa{
    private Integer carterinha;
    private EnumStatusSocio enumStatusSocio;
    private TipoSocio enumTipoSocio;

    public Socio(Integer carterinha, EnumStatusSocio enumStatusSocio,TipoSocio enumTipoSocio, String nome, String cpf, String email, Integer telefone) {
        this.setNomeCompleto(nome);
        this.setEmail(email);
        this.setCpf(cpf);
        this.setTelefone(telefone);
        this.carterinha = carterinha;
        this.enumStatusSocio = enumStatusSocio;
        this.enumTipoSocio = enumTipoSocio;
    }

    public static void add(Socio socios) {
    }

    public Integer getCarterinha() {
        return carterinha;
    }

    public void setCarterinha(Integer carterinha) {
        this.carterinha = carterinha;
    }

    public EnumStatusSocio getEnumStatusSocio() {
        return enumStatusSocio;
    }

    public void setEnumStatusSocio(EnumStatusSocio enumStatusSocio) {
        this.enumStatusSocio = enumStatusSocio;
    }


    public TipoSocio getEnumTipoSocio() {
        return enumTipoSocio;
    }

    public void setEnumTipoSocio(TipoSocio enumTipoSocio) {
        this.enumTipoSocio = enumTipoSocio;
    }
}
