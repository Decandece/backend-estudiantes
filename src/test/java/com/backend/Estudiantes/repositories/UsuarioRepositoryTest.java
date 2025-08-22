package com.backend.Estudiantes.repositories;

import com.backend.Estudiantes.model.Role;
import com.backend.Estudiantes.model.Usuarios.Usuario;
import com.backend.Estudiantes.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class UsuarioRepositoryTest {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void findByEmail_UsuaarioExiste_retornaUsuario() {
        //Constructor de usuario
        Usuario testUser = new Usuario(
                "Test",
                "User",
                "test@pepe.edu.co",
                "123456",
                Role.ESTUDIANTE
        );

        // Guardar el usuario en la base de datos TEST
        Usuario savedUser = usuarioRepository.save(testUser);

        Optional<Usuario> foundUser = usuarioRepository.findByEmail(savedUser.getEmail());

        //Junit TEST IN JAVA
        assertTrue(foundUser.isPresent() , "El usuario deberia existir en la base de datos");

        // Capurando el usuario encontrado
        Usuario encontrado = foundUser.get();

        // Verificar que el usuario encontrado es el mismo que el guardado
        assertEquals("test@pepe.edu.co" , encontrado.getEmail() , "El email del usuario deberia coincidir con el guardado");

    }

}
