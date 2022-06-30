package com.BringBackToLife.nodi.Models.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document
public class Usuario {

    @Id
    private Long ID;
    private LocalDateTime fechaRegistro;
    private LocalDate fechaNacimiento;
    private final DateTimeFormatter formatoFechas = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
    private String apellido;
    private String nombre;
    @DBRef
    private Telefono telefono;
    private List<Grupo> grupos = new ArrayList<>();
    private List<TipoDeEvento> tiposDeAvisos = new ArrayList<>();

    public void setFechaNacimiento(int y, int m, int d) {
        this.fechaNacimiento = LocalDate.of(y,m,d);
    }

}
