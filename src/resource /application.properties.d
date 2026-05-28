# 1. Dirección y base de datos (Usando el puerto 1433 que habilitamos)
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=plataforma_educativa;trustServerCertificate=true

# 2. Credenciales que acabamos de configurar en SQL Management Studio
spring.datasource.username=sa
spring.datasource.password=DASTMUAL-2500
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver

# 3. Configuración de JPA (Para que Java gestione las tablas)
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServerDialect
