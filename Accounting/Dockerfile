FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} accounting.jar
ENTRYPOINT ["java","-jar","/accounting.jar"]