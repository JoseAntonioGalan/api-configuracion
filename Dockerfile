# Seleccionar una imagen base de Java 11
FROM adoptopenjdk/openjdk11:jdk-11.0.12_7-alpine

# Etiqueta de información del mantenedor
LABEL maintainer="Jose Antonio Galan"

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR de la aplicación al contenedor
COPY /target/configuraciones-api-0.0.1.jar app.jar

# Exponer el puerto en el que la aplicación escucha (si es necesario)
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
