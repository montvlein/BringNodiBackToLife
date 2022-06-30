package com.BringBackToLife.nodi.Models.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
@Document
public class Evento {

    @Id
    private Long ID;
    private String nombre;
    private TipoDeEvento tipoDeEvento;
    private LocalDateTime fecha_y_hora;
    private String detalle;
    private boolean isRepeatedEveryYear = false;
    private final static DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");

    public String getFecha_y_hora_formateada() {
        return formatTime.format(fecha_y_hora);
    }

    public int getYear() {
        return fecha_y_hora.getYear();
    }

    public Month getMonth() {
        return fecha_y_hora.getMonth();
    }

    public int getDay() {
        return fecha_y_hora.getDayOfMonth();
    }

    public void setFecha_y_hora(int d, int m, int y, int hr, int min){
        fecha_y_hora = LocalDateTime.of(y,m,d,hr,min);
    }

    public void setFecha_y_hora(int d, int m, int y){
        fecha_y_hora = LocalDateTime.of(y,m,d, 0, 0);
    }

}
