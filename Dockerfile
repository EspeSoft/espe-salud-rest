FROM openjdk:11.0
VOLUME /tmp
EXPOSE 8080
ADD /target/app-1.0.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]