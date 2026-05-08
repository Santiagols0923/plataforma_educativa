stateDiagram-v2 [*] --> No_Autenticado No_Autenticado --> Autenticado: Login Exitoso (id_estado = 2)

state Autenticado {
    [*] --> Explorando: Navega por CURSO / MODULO
    Explorando --> En_Ejercicio: Selecciona EJERCICIO
    
    state En_Ejercicio {
        [*] --> Esperando_Respuesta
        Esperando_Respuesta --> Evaluando: Envía OPCION_RESPUESTA
        Evaluando --> Fallido: es_correcta = false
        Fallido --> Esperando_Respuesta: Reintento
        Evaluando --> Exitoso: es_correcta = true
    }
    
    Exitoso --> Actualizando_Progreso: Registra en RESULTADO
    Actualizando_Progreso --> Verificando_Insignia
    Verificando_Insignia --> Premiado: Se crea registro en USUARIO_INSIGNIA
    Verificando_Insignia --> Explorando: Aún no cumple meta
    Premiado --> Explorando
}

Autenticado --> [*]: Logout


------------------------------------------------------------------------------------------------



stateDiagram-v2
[*] --> Admin_Autenticado: Login (id_rol = 1)

state "Gestión de Usuarios" as Users {
    [*] --> Lista_Usuarios
    Lista_Usuarios --> Suspendiendo: Cambia id_estado a 'Inactivo'
    Suspendiendo --> Lista_Usuarios: Update USUARIO
    Lista_Usuarios --> Activando: Cambia id_estado a 'Activo'
    Activando --> Lista_Usuarios: Update USUARIO
}

state "Gestión de Contenido" as Content {
    [*] --> Creando_Curso: Inserta en CURSO
    Creando_Curso --> Agregando_Modulo: Inserta en MODULO
    Agregando_Modulo --> Configurando_Ejercicio: Define EJERCICIO y NIVEL
    Configurando_Ejercicio --> Publicado: estado = true
    Publicado --> Editando: Ajusta enunciado o puntaje_nivel
}

Admin_Autenticado --> Users
Admin_Autenticado --> Content

Users --> Admin_Autenticado: Regresar al Panel
Content --> Admin_Autenticado: Regresar al Panel
