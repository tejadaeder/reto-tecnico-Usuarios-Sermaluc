package com.ejercicio.tecnico.com.ejercicio.tecnico.aplicacion.Service;

import com.ejercicio.tecnico.com.ejercicio.tecnico.aplicacion.Entity.Usuario;
import com.ejercicio.tecnico.com.ejercicio.tecnico.aplicacion.ErrorHandler.ClaveInvalidaException;
import com.ejercicio.tecnico.com.ejercicio.tecnico.aplicacion.ErrorHandler.CorreoInvalidoException;
import com.ejercicio.tecnico.com.ejercicio.tecnico.aplicacion.ErrorHandler.CorreoRegistradoException;
import com.ejercicio.tecnico.com.ejercicio.tecnico.aplicacion.Repository.UsuarioRepository;
import com.ejercicio.tecnico.com.ejercicio.tecnico.aplicacion.Service.Util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    //private static final String CORREO_REGEX = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    //private static final String claveRegex = "(?=.*[a-zA-Z])(?=.*\\d).{5,}";
    //usuario.clave.regex= (?=.*[a-zA-Z])(?=.*\d).{5,}

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        validarFormatoClave(usuario.getPassword());
        validarCorreoDuplicado(usuario.getEmail());
        validarFormatoCorreo(usuario.getEmail());
        inicializarCamposUsuario(usuario);
        return usuarioRepository.save(usuario);
    }


    private void validarFormatoClave(String password) {
        if (!password.matches(Constantes.CLAVE_REGEX)) {
            throw new ClaveInvalidaException("La contraseña debe contener al menos una mayúscula, una minúscula y un número");
        }
    }

    private void validarCorreoDuplicado(String email) {
        if (usuarioRepository.findByEmail(email) != null) {
            throw new CorreoRegistradoException("Este correo electrónico ya está en uso. Por favor, elige otro.");
        }
    }

    private void validarFormatoCorreo(String email) {
        if (!email.matches(Constantes.CORREO_REGEX)) {
            throw new CorreoInvalidoException("Por favor, introduce un correo electrónico válido");
        }
    }

    private void inicializarCamposUsuario(Usuario usuario) {
        usuario.setId(null);
        usuario.setCreated(new Date());
        usuario.setModified(usuario.getCreated());
        usuario.setLastLogin(usuario.getCreated());
        usuario.setToken(UUID.randomUUID().toString());
        usuario.setActive(true);
    }
}
