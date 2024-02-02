package com.ejercicio.tecnico.com.ejercicio.tecnico.aplicacion.Repository;

import com.ejercicio.tecnico.com.ejercicio.tecnico.aplicacion.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Métodos del repositorio
    Usuario findByEmail(String email);

}