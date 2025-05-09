FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/firs-api-0.0.1-SNAPSHOT.jar firs_api.jar
CMD ["java", "-jar","-Dserver.port=8082", "firs_api.jar "]
