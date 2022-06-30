package com.BringBackToLife.nodi.Services;

import com.BringBackToLife.nodi.Models.Entities.Grupo;
import com.BringBackToLife.nodi.Persistence.ORM.group_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoServicios {

    private group_repository repository;

    @Autowired
    public void setRepository(group_repository repository) {
        this.repository = repository;
    }

    public boolean guardar(Grupo grupo) {
        boolean res = false;
        Grupo nuevoGrupo = repository.save(grupo);
        if (nuevoGrupo != null) {
            res = true;
        }
        return res;
    }

    public boolean eliminar(Long id) {
        boolean res = false;
        Grupo grupo = buscar(id);
        if (grupo != null) {
            repository.deleteById(id);
            res = true;
        }
        return res;
    }

    public Grupo buscar(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Grupo actualizar(Long id, Grupo grupo) {
        Grupo res = grupo;
        Grupo grupo_a_actualizar = buscar(id);
        if (grupo_a_actualizar != null) {
            repository.save(grupo);
            res = grupo_a_actualizar;
        }
        return res;
    }

    public List<Grupo> listarTodos() {
        return repository.findAll();
    }
}
