package com.backend.Estudiantes.service;

import com.backend.Estudiantes.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Data {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init(){
//        Usuario admin = new Usuario();
//        admin.setEmail("pepe@gmail.com");
//        admin.setPassword(passwordEncoder.encode("admin123"));
//        admin.setRol(Role.ADMIN);
//        admin.setNombre("Carlos");
//        admin.setApellido("Perez");
//
//        usuarioRepository.save(admin);
    }
}

