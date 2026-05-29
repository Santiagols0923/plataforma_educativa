package com.plataforma_educativa.educativa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "ESTADO_USUARIO", schema = "dbo")
@Data
public class EstadoUsuario {

    @Id
    @NotNull(message = "El id del estado no puede ser null")
    @Column(name = "id_estado", nullable = false)
    private Integer idEstado;

    @NotBlank(message = "El nombre del estado no puede estar vacío")
    @Size(max = 25)
    @Column(name = "nombre_estado", nullable = false, length = 25)
    private String nombreEstado;
}
