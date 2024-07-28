FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} cabs.jar
CMD ["java","-jar","/cabs.jar"]