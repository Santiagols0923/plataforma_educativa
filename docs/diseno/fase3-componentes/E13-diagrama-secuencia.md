# E13 - DIAGRAMA DE SECUENCIA

## Plataforma Educativa Web - Aprendiendo a Dividir

```mermaid
sequenceDiagram

actor A as Administrador
actor U as Estudiante
participant S as Sistema Spring Boot
participant DB as SQL Server

%% =========================
%% FASE ADMINISTRADOR
%% =========================

Note over A,DB: 1. Gestión de Contenido (Administrador)

A->>S: Inicia sesión
S->>DB: Consultar USUARIO + ROL
DB-->>S: Validación correcta

A->>S: Registrar Curso y Módulo
S->>DB: Insertar CURSO y MODULO
DB-->>S: Datos guardados correctamente

A->>S: Crear Ejercicio
S->>DB: Insertar en EJERCICIO
DB-->>S: Ejercicio registrado

A->>S: Registrar opciones de respuesta
S->>DB: Insertar en OPCION_RESPUESTA
DB-->>S: Opciones registradas

%% =========================
%% FASE ESTUDIANTE
%% =========================

Note over U,DB: 2. Proceso de Aprendizaje (Estudiante)

U->>S: Iniciar sesión (correo y contraseña)
S->>DB: Consultar USUARIO, ROL y ESTADO_USUARIO
DB-->>S: Usuario válido y activo

S-->>U: Acceso al módulo educativo

U->>S: Seleccionar módulo
S->>DB: Consultar ejercicios del módulo
DB-->>S: Lista de ejercicios disponibles

S-->>U: Mostrar ejercicios

U->>S: Resolver ejercicio
S->>DB: Consultar OPCION_RESPUESTA
DB-->>S: Respuesta correcta

S->>S: Validar respuesta del estudiante

alt Respuesta correcta

    S->>DB: Insertar RESULTADO
    S->>DB: Actualizar PROGRESO
    DB-->>S: Resultado guardado

    S-->>U: Mostrar mensaje "Respuesta Correcta"

else Respuesta incorrecta

    S->>DB: Insertar RESULTADO
    DB-->>S: Intento almacenado

    S-->>U: Mostrar retroalimentación

end

%% =========================
%% CIERRE DE SESIÓN
%% =========================

U->>S: Cerrar sesión
S-->>U: Redirección al Login

```

---

# Relación con el Proyecto

Este diagrama representa el flujo real implementado en:

* LoginController
* UsuarioVistaController
* ResultadoVistaController
* ModuloVistaController

---

# Tablas Relacionadas

* USUARIO
* ROL
* ESTADO_USUARIO
* CURSO
* MODULO
* EJERCICIO
* OPCION_RESPUESTA
* RESULTADO
* PROGRESO

---

# Tecnologías Relacionadas

* Spring Boot
* SQL Server
* Thymeleaf
* HTML/CSS
* JPA Repository
* MVC

