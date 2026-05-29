package com.plataforma_educativa.educativa.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "PROGRESO", schema = "dbo")
@Data
public class Progreso {

    @Id
    @NotNull(message = "El id del progreso no puede ser null")
    @Column(name = "id_progreso", nullable = false)
    private Integer idProgresoPK;

    @NotNull(message = "El usuario no puede ser null")
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @NotNull(message = "El módulo no puede ser null")
    @ManyToOne
    @JoinColumn(name = "id_modulo", nullable = false)
    private Modulo modulo;

    @NotNull(message = "La fecha de actualización no puede ser null")
    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;
}
