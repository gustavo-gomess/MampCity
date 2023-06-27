package model;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Aluguel extends Entity {
    private Socio socio;
    private Local local;
    private Inventario inventario;
    private String descricaoAluguel;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String numeroVisitantes;


    public Aluguel(Socio socio,
                   Local local,
                   Inventario inventario,
                   String descricaoAluguel,
                   LocalDateTime dataHoraInicio,
                   LocalDateTime dataHoraFim,
                   String numeroVisitantes) {
        this.socio = socio;
        this.local = local;
        this.inventario = inventario;
        this.descricaoAluguel = descricaoAluguel;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.numeroVisitantes = numeroVisitantes;
    }

    public Socio getSocio() {
        return socio;
    }

    public Inventario getInventario() {
        return inventario;
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

    @Override
    public String toString() {
        return "Aluguel{" +
                "socio=" + socio.getNomeCompleto() +
                ", local=" + local.getNome() +
                ", descricaoAluguel='" + descricaoAluguel + '\'' +
                ", dataHoraInicio=" + dataHoraInicio +
                ", dataHoraFim=" + dataHoraFim +
                ", numeroVisitantes='" + numeroVisitantes + '\'' +
                '}';
    }
}