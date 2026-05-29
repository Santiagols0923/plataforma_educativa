package com.plataforma_educativa.educativa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "OPCION_RESPUESTA", schema = "dbo")
@Data
public class OpcionRespuesta {

    @Id
    @NotNull(message = "El id de la opción no puede ser null")
    @Column(name = "id_opcion", nullable = false)
    private Integer idOpcion;

    @NotNull(message = "El ejercicio no puede ser null")
    @ManyToOne
    @JoinColumn(name = "id_ejercicio", nullable = false)
    private Ejercicio ejercicio;

    @NotNull(message = "La respuesta de la opción no puede ser null")
    @Column(name = "respuesta_opcion", nullable = false)
    private Integer respuestaOpcion;

    @NotNull(message = "Debe indicar si la opción es correcta")
    @Column(name = "es_correcta", nullable = false)
    private Boolean esCorrecta;
}
