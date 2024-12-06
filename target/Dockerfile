# Указываем базовый образ для Java 11
FROM openjdk:11-jre-slim
# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем скомпилированный JAR файл в контейнер
COPY target/backend-1.0-SNAPSHOT.jar backend.jar
# Запускаем JAR
CMD ["java", "-jar", "backend.jar"]