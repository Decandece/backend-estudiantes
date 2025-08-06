package com.backend.Estudiantes.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estudiantes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "codigo_estudiantil", nullable = false, length = 10, unique = true)
    private String codigoEstudiantil;

    @Column(name = "horas_acumuladas", nullable = false)
    private Integer horasAcumuladas;

    @Column(nullable = false, length = 100)
    private String programaAcademico;

    @Column(nullable = false)
    private Integer semestre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoEstudiante estado = EstadoEstudiante.ACTIVO;

    public String getNombreCompleto() {
        if (usuario != null && usuario.getNombre() != null && usuario.getApellido() != null) {
            return usuario.getNombre() + " " + usuario.getApellido();
        }
        return "Nombre no disponible";
    }


}
