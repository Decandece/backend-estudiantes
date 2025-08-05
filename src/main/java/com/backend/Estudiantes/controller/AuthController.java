package com.backend.Estudiantes.controller;

import com.backend.Estudiantes.dto.LoginRequest;
import com.backend.Estudiantes.model.Usuario;
import com.backend.Estudiantes.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("Login")
    public ResponseEntity<?> Login(@Valid @RequestBody LoginRequest request){
        try{
            Usuario usuario = authService.authenticate(request.getEmail() , request.getPassword());
            return ResponseEntity.ok(Map.of(
                    "Message" , "Login exitoso",
                    "Email" , usuario.getEmail(),
                    "Role" , usuario.getRol().name()
            ));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(Map.of(
                    "Error" , e.getMessage()
            ));
        }
    }
}
