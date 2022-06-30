package com.BringBackToLife.nodi.Models.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Document
public class Grupo {

    @Id
    private Long ID;
    private String nombre;
    private String detalle;

    private List<Evento> fechasImportantes = new ArrayList<>();
    private List<Usuario> participantes = new ArrayList<>();

}
