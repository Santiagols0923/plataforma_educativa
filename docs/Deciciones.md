# Registro de Decisiones Arquitectónicas (ADR) - Plataforma Educativa






## 1. Motor de Base de Datos y Driver de Conexión
**Decisión:** Uso de **Microsoft SQL Server 2022** y driver **JDBC (mssql-jdbc)**.
**Sustentación:** Se eligió por su capacidad para manejar integridad referencial compleja y su compatibilidad con entornos empresariales. Se tomó la decisión técnica de habilitar protocolos TCP/IP estáticos en el puerto 1433 para garantizar que el framework Spring Boot localice la instancia de forma determinista.

## 2. Gestión de Dependencias
**Decisión:** Uso de **Maven**.
**Sustentación:** Se seleccionó Maven para automatizar la descarga de librerías y la construcción del proyecto (Build). El archivo `pom.xml` centraliza las dependencias de Spring Data JPA, Spring Web y el driver de SQL Server, asegurando que el entorno sea replicable en otros equipos.

## 3. Mapeo Objeto-Relacional (ORM)
**Decisión:** Implementación de **Spring Data JPA / Hibernate**.
**Sustentación:** Para optimizar el tiempo de desarrollo, se decidió abstraer las consultas SQL manuales. Mediante el uso de `@Entity`, las tablas `ROL`, `NIVEL` y `ESTADO` se manejan como objetos Java, delegando a Hibernate la creación y actualización de esquemas.

## 4. Seguridad de Acceso a Datos
**Decisión:** Configuración de **Autenticación Mixta** y usuario de servicio.
**Sustentación:** Se descartó el uso de Autenticación de Windows para evitar problemas de permisos de sistema operativo. Se habilitó el usuario `sa` con una política de contraseñas específica para permitir que la aplicación se autentique de forma independiente.
---------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------


# DECISIONES TÉCNICAS

## Proyecto: Plataforma Educativa - Spring Boot

---

# Decisión #01

## ¿Qué decidí?

Se decidió utilizar Spring Boot como framework principal para el desarrollo del backend de la plataforma educativa.

---

## ¿Por qué?

Spring Boot permite desarrollar aplicaciones web empresariales de manera rápida y organizada, facilitando:

* La conexión con SQL Server
* La implementación de arquitectura MVC
* La creación de controllers y repositories
* La integración con Thymeleaf
* El manejo de dependencias mediante Maven

Además, permite una mejor organización del código y separación de responsabilidades entre modelos, vistas y lógica del sistema.

---

## ¿Qué artefacto de diseño respalda esta decisión?

* Arquitectura MVC implementada en el proyecto
* Diagramas de clases
* Controllers desarrollados en Spring Boot
* Repositories JPA
* Modelo entidad relación (MER)

---

# Decisión #02

## ¿Qué decidí?

Se decidió implementar control de acceso por roles para diferenciar administradores y estudiantes dentro del sistema.

---

## ¿Por qué?

El sistema requiere diferentes permisos dependiendo del tipo de usuario:

* Administradores → gestión de usuarios
* Estudiantes → acceso a módulos educativos

Esto mejora la seguridad, organización y lógica de negocio de la plataforma.

Además, permite controlar qué vistas puede visualizar cada usuario después del inicio de sesión.

---

## ¿Qué artefacto de diseño respalda esta decisión?

* Tabla rol
* Relación usuario → rol
* Login con validación de roles
* Controllers de redirección
* Casos de uso del sistema

---

# Decisión #03

## ¿Qué decidí?

Se decidió utilizar Thymeleaf para el desarrollo de las vistas dinámicas del sistema.

---

## ¿Por qué?

Thymeleaf permite integrar fácilmente frontend y backend dentro de Spring Boot, facilitando:

* El envío de datos desde controllers
* La construcción de formularios dinámicos
* La integración con modelos JPA
* La renderización de tablas y relaciones

También permitió desarrollar CRUD visuales para las tablas usuario y resultado.

---

## ¿Qué artefacto de diseño respalda esta decisión?

* Vistas HTML implementadas
* Formularios Thymeleaf
* CRUD visual de usuario
* CRUD visual de resultado
* Integración frontend/backend
