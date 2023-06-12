package model;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Aluguel extends Entity{
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