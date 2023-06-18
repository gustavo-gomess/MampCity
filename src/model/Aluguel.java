package model;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Aluguel extends Entity {
    private Socio socio;
    private Local local;
    private String descricaoAluguel;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String numeroVisitantes;


    public Aluguel(Socio socio, Local local, String descricaoAluguel, LocalDateTime inicio, LocalDateTime fim, String numeroVisitantes) {
        super();
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

    public String getNumeroVisitantes() {
        return numeroVisitantes;
    }

    public void setNumeroVisitantes(String numeroVisitantes) {
        this.numeroVisitantes = numeroVisitantes;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }



}