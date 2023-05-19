package model;

public class Dependente {

    private Socio Sócio;

    private String NomeCompleto;

    public void setNomeCompleto(String nomeCompleto) {
        NomeCompleto = nomeCompleto;
    }

    public Socio getSócio() {
        return Sócio;
    }

    public String getNomeCompleto() {
        return NomeCompleto;
    }

    @Override
    public String toString() {
        return "model.Dependente{" +
                "Sócio=" + Sócio +
                ", NomeCompleto='" + NomeCompleto + '\'' +
                '}';
    }

}






