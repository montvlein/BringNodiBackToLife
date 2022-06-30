package com.BringBackToLife.nodi.Services;

import com.BringBackToLife.nodi.Models.Entities.Evento;
import com.BringBackToLife.nodi.Persistence.ORM.event_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServicios {

    private event_repository repository;

    @Autowired
    public void setRepository(event_repository repository) {
        this.repository = repository;
    }

    public boolean guardar(Evento evento) {
        boolean res = false;
        Evento nuevoEvento = repository.save(evento);
        if (nuevoEvento != null) {
            res = true;
        }
        return res;
    }

    public boolean eliminar(Long id) {
        boolean res = false;
        Evento evento = buscar(id);
        if (evento != null) {
            repository.deleteById(id);
            res = true;
        }
        return res;
    }

    public Evento buscar(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Evento actualizar(Long id, Evento evento) {
        Evento res = evento;
        Evento evento_a_actualizar = buscar(id);
        if (evento_a_actualizar != null) {
            repository.save(evento);
            res = evento_a_actualizar;
        }
        return res;
    }

    public List<Evento> listarTodos() {
        return repository.findAll();
    }
}
