package com.BringBackToLife.nodi.Services;

import com.BringBackToLife.nodi.Models.Entities.Telefono;
import com.BringBackToLife.nodi.Persistence.ORM.phone_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefonoServicios {

    private phone_repository repository;

    @Autowired
    public void setRepository(phone_repository repository) {
        this.repository = repository;
    }

    public boolean guardar(Telefono telefono) {
        boolean res = false;
        Telefono nuevoTel = repository.save(telefono);
        if (nuevoTel != null) {
            res = true;
        }
        return res;
    }

    public boolean eliminar(String id) {
        boolean res = false;
        Telefono telefono = buscar(id);
        if (telefono != null) {
            repository.deleteById(id);
            res = true;
        }
        return res;
    }

    public Telefono buscar(String id) {
        return repository.findById(id).orElse(null);
    }

    public Telefono actualizar(String id, Telefono tel) {
        Telefono res = tel;
        Telefono telefonoAActualizar = buscar(id);
        if (telefonoAActualizar != null) {
            repository.save(tel);
            res = telefonoAActualizar;
        }
        return res;
    }

    public List<Telefono> listarTodos() {
        return repository.findAll();
    }
}
