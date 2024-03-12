FROM openjdk:17-jdk-slim AS build

COPY pom.xml mvnw ./ 
COPY .mvn .mvn 
RUN ./mvnw dependency:resolve

COPY src src 
RUN ./mvnw clean
RUN ./mvnw compile package

FROM openjdk:17-jdk-slim AS run
WORKDIR app 
COPY --from=build target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]