package com.plataforma_educativa.educativa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "MODULO", schema = "dbo")
@Data
public class Modulo {

    @Id
    @NotNull(message = "El id del módulo no puede ser null")
    @Column(name = "id_modulo", nullable = false)
    private Integer idModuloPk;

    @NotBlank(message = "El nombre del módulo no puede estar vacío")
    @Size(max = 100)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotNull(message = "El curso no puede ser null")
    @ManyToOne
    @JoinColumn(name = "id_curso_fk", nullable = false)
    private Curso curso;
}
