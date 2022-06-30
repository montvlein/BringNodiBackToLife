package com.BringBackToLife.nodi.Models.Entities;

import lombok.Getter;
import lombok.Setter;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Getter
@Setter
public class Usuario {
    private long id;
    private LocalDateTime fechaRegistro;
    private String apellido;
    private String nombre;
    private Telefono telefono;
    private LocalDate fecha_nacimiento;
    protected ArrayList<Grupo> grupos = new ArrayList<>();
    protected ArrayList<Interes> intereses = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String apellido, String nombre, Telefono telefono, LocalDate fecha_nacimiento, LocalDateTime registro) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        setFechaRegistro(registro);
    }

    public void setId(long userID) {
        this.id = userID;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime registro) {
        if (registro == null) {fechaRegistro = getTelefono().getUltimoRegistro();}
        else {fechaRegistro = registro;}
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(int y, int m, int d) {
        this.fecha_nacimiento = LocalDate.of(y,m,d);
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public ArrayList<Interes> getIntereses() {
        return intereses;
    }

    public void addInteres(Interes i) {
        intereses.add(i);
    }

    public void addGrupo(Grupo g) {
        grupos.add(g);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoFechas = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
        return "Usuario - " +
                "id: " + id +
                ", fechaRegistro: " + formatoFechas.format(fechaRegistro) +
                ", apellido: '" + apellido + '\'' +
                ", nombre: '" + nombre + '\'' +
                ", telefono: " + telefono.getNumero() +
                ", fecha_nacimiento: " + formatoFechas.format(fecha_nacimiento);
    }
}
