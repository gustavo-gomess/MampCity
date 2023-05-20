package model;

public class Dependente {

    private Socio socio;

    private String nomeCompleto;

    public void setNomeCompleto(String nomeCompleto) {
        nomeCompleto = nomeCompleto;
    }

    public Socio getSocio() {
        return socio;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    @Override
    public String toString() {
        return "model.Dependente{" +
                "Sócio=" + socio +
                ", NomeCompleto='" + nomeCompleto + '\'' +
                '}';
    }

}






