FROM openjdk:8-alpine
VOLUME /User/huang/temp
ARG JAR_FILE
ADD target/${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","/app.jar","--eureka.server.ip=127.0.0.1"]
