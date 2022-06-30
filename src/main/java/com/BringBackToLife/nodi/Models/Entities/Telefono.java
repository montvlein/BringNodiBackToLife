package com.BringBackToLife.nodi.Models.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Setter
@Getter
@Document
public class Telefono {

    @Id
    @Indexed(unique = true)
    private String NUMERO;
    private LocalDateTime ultimoRegistro;
    @DBRef
    private Usuario usuario;

}
