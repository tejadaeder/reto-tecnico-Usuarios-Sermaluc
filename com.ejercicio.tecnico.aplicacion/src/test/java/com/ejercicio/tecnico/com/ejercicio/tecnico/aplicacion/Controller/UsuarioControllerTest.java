package com.ejercicio.tecnico.com.ejercicio.tecnico.aplicacion.Controller;

import com.ejercicio.tecnico.com.ejercicio.tecnico.aplicacion.Entity.Usuario;
import com.ejercicio.tecnico.com.ejercicio.tecnico.aplicacion.Repository.UsuarioRepository;
import com.ejercicio.tecnico.com.ejercicio.tecnico.aplicacion.Service.UsuarioServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class UsuarioControllerTest {

    UsuarioRepository usuarioRepository = Mockito.mock(UsuarioRepository.class);
    @InjectMocks
    private com.ejercicio.tecnico.com.ejercicio.tecnico.aplicacion.Controller.UsuarioController usuarioController;

    @Mock
    private UsuarioServiceImpl usuarioService;


    @BeforeEach
    void setUp() {
        Usuario usuario = createTestUsuario();
        Mockito.when(usuarioRepository.save(usuario)).thenReturn(usuario);
    }

    @Test
    public void testRegistrarUsuario() {
        MockitoAnnotations.openMocks(this);

        Usuario usuario = createTestUsuario();

        Mockito.when(usuarioService.registrarUsuario(any(Usuario.class))).thenReturn(usuario);
        ResponseEntity<Usuario> responseEntity = usuarioController.registrarUsuario(usuario);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        Usuario usuarioResponse = responseEntity.getBody();
        assertEquals(1L, usuarioResponse.getId());
        assertEquals("Eder Tejada Mellado", usuarioResponse.getName());
        assertEquals("tejadaeder@gmail.com", usuarioResponse.getEmail());
        assertEquals("Inicio001.", usuarioResponse.getPassword());
    }

    private Usuario createTestUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setName("Eder Tejada Mellado");
        usuario.setEmail("tejadaeder@gmail.com");
        usuario.setPassword("Inicio001.");
        return usuario;
    }
}