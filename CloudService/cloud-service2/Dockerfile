FROM openjdk:8-alpine
VOLUME /User/huang/temp
ARG JAR_FILE
ADD target/${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","/app.jar","--eureka.server.ip=192.168.1.108"]
