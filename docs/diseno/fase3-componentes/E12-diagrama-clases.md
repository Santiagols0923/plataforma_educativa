# E12 - DIAGRAMA DE CLASES

## Plataforma Educativa Web - Aprendiendo a Dividir

```mermaid id="clz81a"
classDiagram

%% =========================
%% CLASES PRINCIPALES
%% =========================

class Usuario {
    +Integer idUsuario
    +String nombre
    +String identificacion
    +String correo
    +String telefono
    +String contrasena
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

class Nivel {
    +Integer idNivel
    +String nombre
    +String descripcion
    +Integer puntajeNivel
}

class Ejercicio {
    +Integer idEjercicio
    +String enunciado
    +Boolean estado
}

class OpcionRespuesta {
    +Integer idOpcion
    +Integer respuestaOpcion
    +Boolean esCorrecta
}

class Resultado {
    +Integer idResultado
    +Integer respuestaUsuario
    +LocalDateTime fecha
}

class Progreso {
    +Integer idProgreso
    +LocalDateTime fechaActualizacion
}

class Insignia {
    +Integer idInsignia
    +String nombre
}

class UsuarioInsignia {
    +Integer idUsuarioInsignia
    +LocalDateTime fechaObtenida
}

%% =========================
%% RELACIONES
%% =========================

Usuario "N" --> "1" Rol : tiene
Usuario "N" --> "1" EstadoUsuario : posee

Usuario "1" --> "N" Resultado : genera
Usuario "1" --> "N" Progreso : registra
Usuario "1" --> "N" UsuarioInsignia : obtiene

Curso "1" --> "N" Modulo : contiene

Modulo "1" --> "N" Ejercicio : agrupa
Modulo "1" --> "N" Progreso : pertenece

Nivel "1" --> "N" Ejercicio : clasifica

Ejercicio "1" --> "N" OpcionRespuesta : contiene
Ejercicio "1" --> "N" Resultado : genera

Insignia "1" --> "N" UsuarioInsignia : asigna

UsuarioInsignia "N" --> "1" Insignia : referencia
UsuarioInsignia "N" --> "1" Usuario : referencia

Resultado "N" --> "1" Usuario : pertenece
Resultado "N" --> "1" Ejercicio : corresponde

Ejercicio "N" --> "1" Nivel : pertenece
Ejercicio "N" --> "1" Modulo : pertenece

Progreso "N" --> "1" Usuario : pertenece
Progreso "N" --> "1" Modulo : pertenece

```

---

# Relación con el Proyecto

Este diagrama representa las entidades implementadas en:

* Spring Boot
* SQL Server
* JPA Repository
* Thymeleaf

y mantiene coherencia con:

* MER del proyecto
* CRUD visual de Usuario
* CRUD visual de Resultado
* Login por roles
* Gestión de módulos y ejercicios

---

# Tecnologías Relacionadas

* Java
* Spring Boot
* SQL Server
* Thymeleaf
* JPA
* MVC
