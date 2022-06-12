package com.BringBackToLife.nodi.Models;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Evento {
    private long ID;
    private String nombre;
    private Interes tipoDeEvento;
    protected LocalDateTime fecha_y_hora;
    private String detalle;
    private boolean isRepeatedEveryYear = false;
    private DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_y_hora() {
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

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public boolean isRepeatedEveryYear() {
        return isRepeatedEveryYear;
    }

    public void setRepeatedEveryYear(boolean repeatedEveryYear) {
        isRepeatedEveryYear = repeatedEveryYear;
    }
}
