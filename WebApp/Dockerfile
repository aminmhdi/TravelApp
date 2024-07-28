FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} webapp.jar
ENTRYPOINT ["java","-jar","/webapp.jar"]