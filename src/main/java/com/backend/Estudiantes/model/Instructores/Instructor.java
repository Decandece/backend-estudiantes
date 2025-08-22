package com.backend.Estudiantes.model.Instructores;

import com.backend.Estudiantes.model.Usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "instructores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id" , nullable = false , unique = true)
    public Usuario usuario;

    @Column(nullable = false)
    private String especialiad;


    private LocalDate fechaContratacion;

}
