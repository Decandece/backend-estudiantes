package com.backend.Estudiantes.service;

import com.backend.Estudiantes.model.Usuario;
import com.backend.Estudiantes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario authenticate(String email, String password) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    //Primero guardamos la contrasea hasheada
    if (!passwordEncoder.matches(password , usuario.getPassword())){
        throw new RuntimeException("Contraseña incorrecta");
    } else {
        // Si la contraseña es correcta, retornamos el usuario
        return usuario;
    }

    }
}
