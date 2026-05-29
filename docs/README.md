
### FASE 1 → Estructura del Proyecto

| Artefacto de Diseño | Lo que genera en el Framework |
| :--- | :--- |
| **E5 - Diagrama de Componentes** | [cite_start]Define la estructura de carpetas y paquetes del proyecto Spring Boot, organizando el código en `controller`, `model` y `repository`. |
| **E6 - Diagrama de Despliegue** | [cite_start]Establece la configuración del entorno en `application.properties`, incluyendo la conexión al puerto 8080/8081 y las variables para el servidor SQL Server. |
| **E4 - Arquetipos** | [cite_start]Determina los nombres de las clases de entidad (`Usuario`, `Rol`, `Nivel`, `Curso`), así como la estructura de los modelos y servicios RESTful. |

### FASE 2 → Capa de Datos

| Artefacto de Diseño | Lo que genera en el Framework |
| :--- | :--- |
| **E11 - Script DDL** | [cite_start]Creación física de las 12 tablas en SQL Server, definiendo tipos de datos, llaves primarias y foráneas para la persistencia [cite: 18-112]. |
| **E9-E10 - Modelo Relacional** | [cite_start]Estructura lógica que se traduce en clases `@Entity` de Java, permitiendo la comunicación entre el objeto y la tabla mediante JPA [cite: 17, 48-112]. |
| **E7 - Diccionario de Datos** | [cite_start]Define las validaciones y restricciones técnicas (como `@Column`) y tipos de variables (String, Integer) en los modelos [cite: 1-15, 48-112]. |
| **E8 - MER** | [cite_start]Determina la cardinalidad y lógica de las relaciones que se implementan en el código mediante anotaciones como `@ManyToOne` [cite: 16, 48-112]. |

### FASE 3 → Lógica de Negocio

| Artefacto de Diseño | Lo que genera en el Framework |
| :--- | :--- |
| **E12 - Diagrama de Clases** | [cite_start]Estructura de Clases de Entidad, Interfaces de Repositorios y lógica de Servicios en el backend . |
| **E13 - Diagramas de Secuencia** | [cite_start]Define el flujo de los métodos en los Controladores y la interacción entre servicios para procesar peticiones . |
| **E14 - Diagrama de Estados** | [cite_start]Determina los campos de estado en la base de datos (como en `ESTADO_USUARIO`) y la lógica para transiciones de procesos . |
-----------------------------------------------------------------------------------------


# PLATAFORMA EDUCATIVA - SPRING BOOT

## Descripción del proyecto

Este proyecto consiste en el desarrollo de una plataforma educativa enfocada en ejercicios académicos interactivos para estudiantes. El sistema permite la gestión de usuarios, módulos, ejercicios y resultados, implementando relaciones entre tablas maestras y transaccionales mediante Spring Boot y SQL Server.

Además, el sistema cuenta con autenticación básica por roles, permitiendo diferenciar administradores y estudiantes.

---

# ¿Qué módulo implementa?

El proyecto implementa principalmente el módulo de:

* Gestión de Usuarios
* Gestión de Resultados
* Inicio de sesión por roles
* Visualización de módulos educativos

---

# ¿Qué tablas cubre el módulo?

## Tablas maestras

* usuario
* rol
* estado_usuario
* modulo
* nivel
* ejercicio
* curso
* insignia

## Tablas transaccionales

* resultado
* usuario_insignia
* progreso
* opcion_respuesta

---

# Tecnologías utilizadas

El proyecto fue desarrollado utilizando las siguientes tecnologías:

* Java
* Spring Boot
* Spring MVC
* Spring Data JPA
* Thymeleaf
* HTML5
* CSS3
* SQL Server
* Maven

---

# ¿Por qué se eligió Spring Boot?

Se eligió Spring Boot porque permite desarrollar aplicaciones web empresariales de manera rápida y organizada, facilitando:

* La conexión con bases de datos
* La implementación de arquitectura MVC
* El manejo de dependencias mediante Maven
* La creación de APIs y vistas dinámicas
* La integración con Thymeleaf

---

# Funcionalidades implementadas

## Gestión de Usuarios

* Registrar usuarios
* Listar usuarios
* Eliminar usuarios
* Inicio de sesión
* Redirección según rol

## Gestión de Resultados

* Registrar resultados de ejercicios
* Relación entre usuario y ejercicio
* Fecha automática de registro
* Listar resultados
* Eliminar resultados

## Inicio de sesión

* Administrador → acceso a gestión de usuarios
* Estudiante → acceso a módulos

---

# Regla de negocio implementada

El sistema implementa lógica de negocio basada en roles:

* Si el usuario tiene rol 1 → Administrador
* Si el usuario tiene rol 2 → Estudiante

Dependiendo del rol, el sistema redirecciona automáticamente a diferentes vistas.

Además, la fecha del resultado se genera automáticamente al guardar un ejercicio.

---

# Cómo ejecutar el proyecto

## Requisitos

* Java JDK 17 o superior
* SQL Server
* Maven
* Visual Studio Code o IntelliJ IDEA

---

## Pasos

1. Clonar el repositorio
2. Abrir el proyecto en Visual Studio Code
3. Configurar la conexión a SQL Server en:

application.properties

4. Ejecutar la aplicación Spring Boot
5. Abrir el navegador en:

http://localhost:8080/registro-login

---

# Estructura del proyecto

El proyecto utiliza arquitectura MVC:

* Model → entidades JPA
* Repository → acceso a datos
* Controller → lógica del sistema
* Templates → vistas Thymeleaf
* Static → archivos CSS

---

# Integrantes

* Dairon Stiven Murcia Alvarez
* Santiago Londoño Serna

---

# Repositorio del compañero

Pendiente por agregar.
