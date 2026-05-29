package com.plataforma_educativa.educativa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "ROL", schema = "dbo")
@Data
public class Rol {

    @Id
    @NotNull(message = "El id del rol no puede ser null")
    @Column(name = "id_rol", nullable = false)
    private Integer idRol;

    @NotBlank(message = "El nombre del rol no puede estar vacío")
    @Size(max = 50)
    @Column(name = "nombre", nullable = false, unique = true, length = 50)
    private String nombre;
}
