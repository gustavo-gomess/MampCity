package model;

import java.math.BigDecimal;

public class Funcionario extends Pessoa {
    private String cargo;
    private String setor;
    private String expediente;
    private BigDecimal salario;

    public Funcionario(String cargo,
                       String setor,
                       String expediente,
                       BigDecimal salario,
                       String nome,
                       String email,
                       String cpf,
                       Integer telefone) {
        this.setNomeCompleto(nome);
        this.setEmail(email);
        this.setCpf(cpf);
        this.setTelefone(telefone);
        this.cargo = cargo;
        this.setor = setor;
        this.expediente = expediente;
        this.salario = salario;
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

    @Override
    public String toString() {
        return "Funcionario{" +
                ", nome='" + this.getNomeCompleto() + '\'' +
                ", telefone= '" + this.getTelefone() + '\'' +
                ", CPF ='" + this.getCpf() + '\'' +
                ", email=' " + this.getEmail() + '\'' +
                "cargo='" + cargo + '\'' +
                ", setor='" + setor + '\'' +
                ", expediente='" + expediente + '\'' +
                ", salario=" + salario +
                '}';
    }
}





