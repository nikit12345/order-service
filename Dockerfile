
FROM openjdk:17-alpine
EXPOSE 9092

WORKDIR	/opt
COPY target/*jar /opt/Order-Service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar Order-Service.jar

