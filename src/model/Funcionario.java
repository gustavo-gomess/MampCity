package model;

import java.math.BigDecimal;

public class Funcionario extends Pessoa{
    private String clt;
    private String cargo;
    private String setor;
    private String expediente;
    private BigDecimal salario;

    public Funcionario(String clt, String cargo, String setor, String expediente, BigDecimal salario) {
        this.clt = clt;
        this.cargo = cargo;
        this.setor = setor;
        this.expediente = expediente;
        this.salario = salario;
    }


    public String getClt() {
        return clt;
    }

    public void setClt(String clt) {
        this.clt = clt;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}





