package com.plataforma_educativa.educativa.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "RESULTADO", schema = "dbo")
@Data
public class Resultado {

    @Id
    @NotNull(message = "El id del resultado no puede ser null")
    @Column(name = "id_resultado", nullable = false)
    private Integer idResultado;

    @NotNull(message = "El usuario no puede ser null")
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @NotNull(message = "El ejercicio no puede ser null")
    @ManyToOne
    @JoinColumn(name = "id_ejercicio", nullable = false)
    private Ejercicio ejercicio;

    @NotNull(message = "La respuesta del usuario no puede ser null")
    @Column(name = "respuesta_usuario", nullable = false)
    private Integer respuestaUsuario;

    @NotNull(message = "La fecha no puede ser null")
    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;
}
