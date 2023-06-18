package model;

public class Socio extends Pessoa{
    private Integer carterinha;
    private StatusSocio statusSocio;
    private TipoSocio enumTipoSocio;

    public Socio(Integer carterinha, StatusSocio statusSocio, TipoSocio enumTipoSocio, String nome, String cpf, String email, Integer telefone) {
        this.setNomeCompleto(nome);
        this.setEmail(email);
        this.setCpf(cpf);
        this.setTelefone(telefone);
        this.carterinha = carterinha;
        this.statusSocio = statusSocio;
        this.enumTipoSocio = enumTipoSocio;
    }

    public Socio(String nome,  Integer telefone,String email) {
        this.setNomeCompleto(nome);
        this.setTelefone(telefone);
        this.setEmail(email);
    }

    public Socio() {

    }

    public Integer getCarterinha() {
        return carterinha;
    }

    public void setCarterinha(Integer carterinha) {
        this.carterinha = carterinha;
    }

    public StatusSocio getEnumStatusSocio() {
        return statusSocio;
    }

    public void setEnumStatusSocio(StatusSocio statusSocio) {
        this.statusSocio = statusSocio;
    }


    public TipoSocio getEnumTipoSocio() {
        return enumTipoSocio;
    }

    public void setEnumTipoSocio(TipoSocio enumTipoSocio) {
        this.enumTipoSocio = enumTipoSocio;
    }
}
