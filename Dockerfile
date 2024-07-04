FROM openjdk:17-alpine
EXPOSE 8092
ADD target/Gestion_des_application-0.0.1-SNAPSHOT.jar applications.jar
ENTRYPOINT ["java","-jar","applications.jar"]
