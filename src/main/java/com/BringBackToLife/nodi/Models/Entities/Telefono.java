package com.BringBackToLife.nodi.Models.Entities;

import java.time.LocalDateTime;

public class Telefono {
    private long numero;
    private LocalDateTime ultimoRegistro;

    public Telefono(long numero) {
        this.numero = numero;
        ultimoRegistro.now();
    }

    public Telefono(long numero, LocalDateTime ultimoRegistro) {
        this.numero = numero;
        this.ultimoRegistro = ultimoRegistro;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public LocalDateTime getUltimoRegistro() {
        return ultimoRegistro;
    }

    public void setUltimoRegistro(LocalDateTime ultimoRegistro) {
        this.ultimoRegistro = ultimoRegistro;
    }
}
