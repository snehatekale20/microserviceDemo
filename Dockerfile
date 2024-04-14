FROM openjdk:17
ADD target/MicroserviceDemo-0.0.1-SNAPSHOT.jar MicroserviceDemo-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "MicroserviceDemo-0.0.1-SNAPSHOT.jar" ]