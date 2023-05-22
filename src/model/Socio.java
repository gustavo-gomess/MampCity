package model;

public class Socio extends Pessoa {
    private String nome;
    private String cpf;
    private String email;

    public Socio(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Socio{" +
                ", nome='" + this.getNomeCompleto() + '\'' +
                ", telefone= '" + this.getTelefone() + '\'' +
                ", CPF ='" + this.getCpf() + '\'' +
                ", email=' " + this.getEmail() + '\'' +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
