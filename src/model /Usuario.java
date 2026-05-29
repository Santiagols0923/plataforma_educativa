package com.plataforma_educativa.educativa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "USUARIO", schema = "dbo")
@Data
public class Usuario {

    @Id
    @NotNull(message = "El id del usuario no puede ser null")
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Size(max = 20)
    @Column(name = "identificacion", length = 20)
    private String identificacion;

    @NotBlank(message = "El correo no puede estar vacío")
    @Size(max = 100)
    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Size(max = 10)
    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(max = 255)
    @Column(name = "contraseña", nullable = false, length = 255)
    private String contrasena;

    @NotNull(message = "El rol no puede ser null")
    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    @NotNull(message = "El estado no puede ser null")
    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private EstadoUsuario estado;
}
