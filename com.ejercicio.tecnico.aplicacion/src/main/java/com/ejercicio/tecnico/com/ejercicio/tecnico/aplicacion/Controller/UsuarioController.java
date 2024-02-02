package com.ejercicio.tecnico.com.ejercicio.tecnico.aplicacion.Controller;

import com.ejercicio.tecnico.com.ejercicio.tecnico.aplicacion.Entity.Usuario;
import com.ejercicio.tecnico.com.ejercicio.tecnico.aplicacion.Service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {

        Usuario registrado = usuarioService.registrarUsuario(usuario);
        return new ResponseEntity<>(registrado, HttpStatus.CREATED);
    }
}
