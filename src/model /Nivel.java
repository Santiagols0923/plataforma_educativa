package com.plataforma_educativa.educativa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "NIVEL", schema = "dbo")
@Data
public class Nivel {

    @Id
    @NotNull(message = "El id del nivel no puede ser null")
    @Column(name = "id_nivel", nullable = false)
    private Integer idNivel;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 25)
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;

    @Size(max = 50)
    @Column(name = "descripcion", length = 50)
    private String descripcion;

    @NotNull(message = "El puntaje del nivel no puede ser null")
    @Column(name = "puntaje_nivel", nullable = false)
    private Integer puntajeNivel;
}
