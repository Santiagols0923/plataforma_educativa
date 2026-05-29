package com.plataforma_educativa.educativa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "EJERCICIO", schema = "dbo")
@Data
public class Ejercicio {

    @Id
    @NotNull(message = "El id del ejercicio no puede ser null")
    @Column(name = "id_ejercicio", nullable = false)
    private Integer idEjercicio;

    @NotBlank(message = "El enunciado no puede estar vacío")
    @Size(max = 50)
    @Column(name = "enunciado", nullable = false, length = 50)
    private String enunciado;

    @NotNull(message = "El nivel no puede ser null")
    @ManyToOne
    @JoinColumn(name = "id_nivel", nullable = false)
    private Nivel nivel;

    @NotNull(message = "El estado no puede ser null")
    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @NotNull(message = "El módulo no puede ser null")
    @ManyToOne
    @JoinColumn(name = "id_modulo", nullable = false)
    private Modulo modulo;
}
