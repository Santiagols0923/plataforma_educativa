package com.plataforma_educativa.educativa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "INSIGNIA", schema = "dbo")
@Data
public class Insignia {

    @Id
    @NotNull(message = "El id de la insignia no puede ser null")
    @Column(name = "id_insignia", nullable = false)
    private Integer idInsignia;

    @NotBlank(message = "El nombre de la insignia no puede estar vacío")
    @Size(max = 10)
    @Column(name = "nombre", nullable = false, length = 10)
    private String nombre;
}
