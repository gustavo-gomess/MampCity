package model;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Aluguel {

    private Socio socio;

    private Local local;

    private String descricaoAluguel;

    private LocalDateTime dataHoraInicio;

    private LocalDateTime dataHoraFim;

    private List<String> visitantes;


    public Aluguel(String descricaoAluguel, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, List<String> visitantes) {
        this.descricaoAluguel = descricaoAluguel;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.visitantes = visitantes;
    }

    public void alugar (){}

    public Socio getSocio() {
        return socio;
    }

    public Local getLocal() {
        return local;
    }

    public String getDescricao() {
        return descricaoAluguel;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public List<String> getVisitantes() {
        return visitantes;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public void setDescricao(String descricao) {
        this.descricaoAluguel = descricao;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public void setVisitantes(List<String> visitantes) {
        this.visitantes = visitantes;
    }

    @Override
    public String toString() {
        return "Aluguel{" +
                "socio=" + socio +
                ", local=" + local +
                ", descricaoAluguel='" + descricaoAluguel + '\'' +
                ", dataHoraInicio=" + dataHoraInicio +
                ", dataHoraFim=" + dataHoraFim +
                ", visitantes=" + visitantes +
                '}';
    }
}