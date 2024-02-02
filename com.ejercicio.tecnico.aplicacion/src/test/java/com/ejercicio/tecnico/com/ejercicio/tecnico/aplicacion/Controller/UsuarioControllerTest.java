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


    @Mock
    private UsuarioServiceImpl usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @BeforeEach
    void setUp() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setName("Juan Rodriguez");
        usuario.setEmail("juas4@rodriguez.com");
        usuario.setPassword("Eder12345");
         Mockito.when(usuarioRepository.save(usuario)).thenReturn(usuario);

    }

    @Test
    public void testRegistrarUsuario() {
        // Configuración
        MockitoAnnotations.openMocks(this);

        Usuario usuario = new Usuario();
        usuario.setName("Juan Rodriguez");
        usuario.setEmail("juas4@rodriguez.com");
        usuario.setPassword("Eder12345");

        Usuario usuarioRegistrado = new Usuario();
        usuarioRegistrado.setId(1L);
        usuarioRegistrado.setName("Juan Rodriguez");
        usuarioRegistrado.setEmail("juas4@rodriguez.com");
        usuarioRegistrado.setPassword("Eder12345");
        Mockito.when(usuarioService.registrarUsuario(any(Usuario.class))).thenReturn(usuarioRegistrado);

        // Ejecución
        ResponseEntity<Usuario> responseEntity = usuarioController.registrarUsuario(usuario);

        // Verificación
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        Usuario usuarioResponse = responseEntity.getBody();
        assertEquals(1L, usuarioResponse.getId());
        assertEquals("Juan Rodriguez", usuarioResponse.getName());
        assertEquals("juas4@rodriguez.com", usuarioResponse.getEmail());
        assertEquals("Eder12345",usuarioResponse.getPassword());
    }
}