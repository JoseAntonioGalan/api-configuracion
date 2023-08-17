FROM adoptopenjdk/openjdk11:jdk-11.0.12_7-alpine

LABEL maintainer="Jose Antonio Galan"

WORKDIR /app

COPY /target/configuraciones-api-0.0.1.jar app.jar

EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
