package model;

public class Local extends Entity {
    private String nome;
    private String descricacaoLocal;

    public Local(String nome, String descricacaoLocal) {
        this.nome = nome;
        this.descricacaoLocal = descricacaoLocal;
    }

    public Local() {
    }

    public String getNome() {
        return nome;
    }

    public String getDescricacaoLocal() {
        return descricacaoLocal;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricacaoLocal(String descricacaoLocal) {
        this.descricacaoLocal = descricacaoLocal;
    }


}
