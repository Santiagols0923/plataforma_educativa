

# M4 - Nodos de Despliegue y Protocolos

| Nodo | Componente | Protocolo | Requisito No Funcional (RNF) |
| :--- | :--- | :--- | :--- |
| **Servidor Web** | Spring Boot App | HTTPS (TLS 1.2+) | [cite_start]RNF-13.2: Seguridad [cite: 394] |
| **Base de Datos**| SQL Server | JDBC / ORM | [cite_start]RNF-13.3: Rendimiento (<2s) [cite: 395] |
| **Cliente Web** | Interfaz Usuario | HTTP / TCP/IP | [cite_start]RNF-13.5: Usabilidad [cite: 397] |
| **Servicio Email**| Notificaciones | SMTP | [cite_start]RNF-13.12: Trazabilidad [cite: 404] |
