
# Bitácora de Desarrollo - Proyecto Plataforma Educativa

## Semana 1: Inicialización del Ecosistema
* **Actividades:** * Generación del proyecto base mediante Spring Initializr.
    * Organización de la estructura de paquetes: `controller`, `model`, `repository`.
    * Configuración del entorno de desarrollo en Visual Studio Code.
* **Logro:** Framework Spring Boot inicializado y corriendo localmente.

## Semana 2: Persistencia y Modelo de Datos
* **Actividades:** * Creación de tablas mediante sentencias DDL en SQL Server.
    * Definición de clases `@Entity` en Java con anotaciones JPA.
    * Configuración del archivo `application.properties` para vinculación con el motor de base de datos.
* **Logro:** Modelos ORM creados con mapeo correcto de llaves primarias.

## Semana 3: Conectividad y CRUD de Tablas Maestras
* **Actividades:** * **Resolución de conflictos de red:** Configuración de puertos y protocolos TCP/IP en SQL Server Configuration Manager.
    * **Gestión de Seguridad:** Habilitación de acceso SQL Server Authentication y configuración de credenciales de usuario.
    * **Desarrollo de API:** Creación de Repositorios e Interfaces para tablas `ROL`, `NIVEL` y `ESTADO`.
    * **Verificación:** Pruebas de endpoints REST mediante navegador, obteniendo respuestas en formato JSON.
* **Logro:** CRUD de lectura (Read) funcionando al 100% para todas las tablas maestras.

### Semana 3 - Finalización de Conexión y CRUD Maestro
* **Actividades:** * Configuración exitosa de protocolos TCP/IP en SQL Server.
    * Implementación de la entidad `Rol` y su mapeo ORM.
    * Creación del repositorio `RolRepository` extendiendo de JpaRepository.
    * Desarrollo del controlador `RolController` para exposición de datos vía API REST.
* **Resultado:** CRUD de tablas maestras funcionando y verificado mediante peticiones HTTP al puerto 8080.
------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------

# BITACORA DE DESARROLLO

## Proyecto: Plataforma Educativa - Spring Boot

---

# Entrada #01 — 08/05/2026

## ¿Qué hice?

Durante esta etapa se realizó el análisis inicial del proyecto y la construcción del modelo entidad relación (MER) de la plataforma educativa. Se definieron las tablas maestras y transaccionales del sistema, incluyendo usuario, rol, estado_usuario, modulo, ejercicio, nivel, resultado y progreso.

También se inició la creación del backend con Spring Boot utilizando arquitectura MVC, creando entidades JPA, repositories y controllers básicos.

---

## ¿Qué problema encontré?

Se presentaron dificultades al momento de relacionar correctamente las tablas mediante claves foráneas y definir qué tablas debían considerarse maestras y cuáles transaccionales.

También surgieron dudas relacionadas con la estructura correcta de entidades JPA y las relaciones @ManyToOne.

---

## ¿Cómo lo resolví?

Se reorganizó el modelo relacional utilizando claves foráneas para mantener la integridad referencial. Posteriormente se corrigieron las relaciones JPA y se ajustaron los modelos utilizando anotaciones como:

* @ManyToOne
* @JoinColumn
* @Entity

También se verificó la estructura de las tablas directamente desde SQL Server.

---

## ¿Usé IA?

Sí.

### ¿Qué ajusté del resultado?

Se ajustaron las relaciones propuestas por IA para adaptarlas al MER definido en el proyecto y a los nombres reales de las tablas y atributos utilizados en SQL Server.

---

# Entrada #02 — 15/05/2026

## ¿Qué hice?

Se desarrolló la lógica backend utilizando Spring Boot y SQL Server. Durante esta etapa se implementó:

* CRUD de usuarios
* Login funcional
* Validación por roles
* Registro de estudiantes
* Controllers visuales con Thymeleaf
* Conexión frontend y backend

También se desarrolló la vista visual de usuarios con HTML y CSS, permitiendo registrar, listar y eliminar usuarios desde el navegador.

---

## ¿Qué problema encontré?

Se presentaron errores relacionados con Thymeleaf y el envío de objetos Model desde los controllers. También hubo inconvenientes relacionados con rutas inexistentes y validaciones de formularios.

Además, se detectó que los IDs manuales generaban problemas al registrar usuarios desde el sistema visual.

---

## ¿Cómo lo resolví?

Se reorganizaron los controllers utilizando:

* @Controller
* @GetMapping
* @PostMapping

También se corrigieron rutas, formularios y atributos enviados mediante Model.

Finalmente se decidió utilizar IDs autoincrementables para facilitar el registro automático de usuarios.

---

## ¿Usé IA?

Sí.

### ¿Qué ajusté del resultado?

Se ajustaron rutas, nombres de atributos, formularios Thymeleaf y validaciones sugeridas por IA para que coincidieran con la estructura real del proyecto.

---

# Entrada #03 — 28/05/2026

## ¿Qué hice?

Durante esta etapa final se implementó el CRUD visual de la tabla transaccional resultado, incluyendo:

* Relación entre usuario y ejercicio
* Fecha automática
* CRUD visual
* Diseño moderno con CSS
* Validación de login por roles

También se desarrolló la lógica para diferenciar administradores y estudiantes:

* Rol 1 → administrador
* Rol 2 → estudiante

Dependiendo del rol, el sistema redirecciona automáticamente a diferentes vistas.

Además, se realizaron pruebas funcionales completas del sistema utilizando SQL Server y Spring Boot.

---

## ¿Qué problema encontré?

Se presentaron inconvenientes relacionados con:

* Fechas tipo datetime2(7)
* Filtrado de estudiantes por rol
* Conexión de CSS con Thymeleaf
* IDs manuales en tablas transaccionales

También hubo errores de sintaxis y mapeo en consultas derivadas de JPA.

---

## ¿Cómo lo resolví?

Se implementó:

* LocalDateTime.now() para fechas automáticas
* Mejor organización de controllers visuales
* Corrección de rutas CSS
* Ajustes en consultas JPA
* Validaciones de roles en login

También se reorganizó la estructura visual para mejorar la presentación del sistema.

---

## ¿Usé IA?

Sí.

### ¿Qué ajusté del resultado?

Se ajustaron estilos visuales, validaciones, consultas JPA, relaciones entre entidades y lógica de redirección por roles para adaptarlos a la arquitectura real del proyecto y los requerimientos del parcial.
