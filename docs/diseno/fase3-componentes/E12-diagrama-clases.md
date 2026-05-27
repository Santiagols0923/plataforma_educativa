classDiagram
    class Usuario {
        +Integer idUsuario
        +String nombre
        +String identificacion
        +String correo
        +String telefono
        +String contraseña
    }

    class Rol {
        +Integer idRol
        +String nombre
    }

    class EstadoUsuario {
        +Integer idEstado
        +String nombreEstado
    }

    class Curso {
        +Integer idCurso
        +String nombre
        +String descripcion
    }

    class Modulo {
        +Integer idModulo
        +String nombre
    }

    class Ejercicio {
        +Integer idEjercicio
        +String enunciado
        +Boolean estado
    }

    class Nivel {
        +Integer idNivel
        +String nombre
        +String descripcion
        +Integer puntajeNivel
    }

    class OpcionRespuesta {
        +Integer idOpcion
        +Integer respuestaOpcion
        +Boolean esCorrecta
    }

    class Resultado {
        +Integer idResultado
        +Integer respuestaUsuario
        +DateTime fecha
    }

    class Progreso {
        +Integer idProgreso
        +DateTime fechaActualizacion
    }

    class Insignia {
        +Integer idInsignia
        +String nombre
    }

    class UsuarioInsignia {
        +Integer idUsuarioInsignia
        +DateTime fechaObtenida
    }

    %% Relaciones
    Usuario "n" -- "1" Rol : tiene
    Usuario "n" -- "1" EstadoUsuario : posee
    Usuario "1" -- "n" Resultado : genera
    Usuario "1" -- "n" Progreso : registra
    Usuario "1" -- "n" UsuarioInsignia : obtiene

    Curso "1" -- "n" Modulo : contiene
    Modulo "1" -- "n" Ejercicio : agrupa
    Modulo "1" -- "n" Progreso : pertenece

    Ejercicio "n" -- "1" Nivel : categorizado
    Ejercicio "1" -- "n" OpcionRespuesta : ofrece
    Ejercicio "1" -- "n" Resultado : evaluado

    Insignia "1" -- "n" UsuarioInsignia : otorgada
