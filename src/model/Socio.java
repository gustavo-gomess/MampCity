package model;

import java.math.BigDecimal;
import java.util.List;

public class Socio extends Pessoa{
    private Integer carterinha;
    private EnumStatusSocio enumStatusSocio;
    private BigDecimal valorMensalidade;
    private List<Dependente> dependente;

    public Socio(Integer carterinha, EnumStatusSocio enumStatusSocio, BigDecimal valorMensalidade, List<Dependente> dependente, String nome, String cpf, String email, Integer telefone) {
        this.setNomeCompleto(nome);
        this.setEmail(email);
        this.setCpf(cpf);
        this.setTelefone(telefone);
        this.carterinha = carterinha;
        this.enumStatusSocio = enumStatusSocio;
        this.valorMensalidade = valorMensalidade;
        this.dependente = dependente;
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

    public BigDecimal getValorMensalidade() {
        return valorMensalidade;
    }

    public void setValorMensalidade(BigDecimal valorMensalidade) {
        this.valorMensalidade = valorMensalidade;
    }

    public List<Dependente> getDependente() {
        return dependente;
    }

    public void setDependente(List<Dependente> dependente) {
        this.dependente = dependente;
    }

    @Override
    public String toString() {
        return "Socio{" +
                ", nome='" + this.getNomeCompleto() + '\'' +
                ", telefone= '" + this.getTelefone() + '\'' +
                ", CPF ='" + this.getCpf() + '\'' +
                ", email=' " + this.getEmail() + '\'' +
                " arterinha=" + carterinha +
                ", enumStatusSocio=" + enumStatusSocio +
                ", valorMensalidade=" + valorMensalidade +
                ", dependente=" + dependente +
                '}';
    }
}
