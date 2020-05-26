FROM openjdk:8-jdk-alpine

# We only run with user level privleges (See https://security.stackexchange.com/questions/106860/can-a-root-user-inside-a-docker-lxc-break-the-security-of-the-whole-system)
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Entrypoint is used, so there is no shell process wrapping the java call.
ENTRYPOINT ["java","-jar","/app.jar"]