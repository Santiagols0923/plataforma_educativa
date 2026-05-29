package com.plataforma_educativa.educativa.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "USUARIO_INSIGNIA", schema = "dbo")
@Data
public class UsuarioInsignia {

    @Id
    @NotNull(message = "El id de usuario insignia no puede ser null")
    @Column(name = "id_usuario_insignia", nullable = false)
    private Integer idUsuarioInsignia;

    @NotNull(message = "El usuario no puede ser null")
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @NotNull(message = "La insignia no puede ser null")
    @ManyToOne
    @JoinColumn(name = "id_insignia", nullable = false)
    private Insignia insignia;

    @NotNull(message = "La fecha obtenida no puede ser null")
    @Column(name = "fecha_obtenida", nullable = false)
    private LocalDateTime fechaObtenida;
}
