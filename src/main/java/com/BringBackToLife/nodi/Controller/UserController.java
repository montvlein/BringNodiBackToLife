package com.BringBackToLife.nodi.Controller;

import com.BringBackToLife.nodi.Models.Usuario;
import com.BringBackToLife.nodi.Services.UsuarioServicios;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UsuarioServicios servicio = new UsuarioServicios();

    @GetMapping("/v1/user/{userID}")
    @ResponseBody
    public ResponseEntity<Usuario> perfilDeUsuario(@PathVariable long userID) {
        ResponseEntity<Usuario> response;
        Usuario user = servicio.buscar(userID);
        if (user != null) {
            try {
                response = ResponseEntity.ok(user);
            } catch (Exception ex) {
                response = ResponseEntity.badRequest().body(null);
            }
        }
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }
}
