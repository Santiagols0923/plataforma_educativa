sequenceDiagram
    autonumber
    participant A as Administrador
    participant U as Estudiante (Usuario)
    participant S as Sistema (Spring Boot)
    participant DB as Base de Datos (SQL Server)

    Note over A, DB: 1. Fase de Preparación (Administrador)
    A->>S: Registra nuevo Curso y Módulo
    S->>DB: Insertar en CURSO y MODULO
    DB-->>S: Confirmación de guardado
    A->>S: Crea Ejercicios con Nivel y Opciones
    S->>DB: Insertar en EJERCICIO, NIVEL y OPCION_RESPUESTA
    DB-->>S: Contenido publicado exitosamente

    Note over U, DB: 2. Fase de Aprendizaje (Estudiante)
    U->>S: Inicia sesión (Correo/Password)
    S->>DB: Consultar USUARIO, ROL y ESTADO_USUARIO
    DB-->>S: Valida acceso (Activo) y Tipo de Rol
    
    U->>S: Selecciona un Módulo para practicar
    S->>DB: Buscar EJERCICIOS vinculados al MODULO
    DB-->>S: Retorna Enunciados y Opciones
    
    U->>S: Envía respuesta del ejercicio
    S->>S: Compara con campo "es_correcta"
    
    S->>DB: Insertar en RESULTADO y actualizar PROGRESO
    DB-->>S: Registros actualizados
    
    Note over S, DB: 3. Fase de Recompensa
    S->>DB: Verificar cumplimiento de metas (INSIGNIA)
    DB->>DB: Crear registro en USUARIO_INSIGNIA
    
    S-->>U: Notifica: "¡Ejercicio Correcto e Insignia Obtenida!"
    
