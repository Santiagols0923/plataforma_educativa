package com.plataforma_educativa.educativa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "CURSO", schema = "dbo")
@Data
public class Curso {

    @Id
    @NotNull(message = "El id del curso no puede ser null")
    @Column(name = "id_curso_PK", nullable = false)
    private Integer idCursoPK;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(max = 255)
    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;
}
