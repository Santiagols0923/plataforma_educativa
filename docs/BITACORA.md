
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
