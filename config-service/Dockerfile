FROM openjdk:17

WORKDIR /tmp

COPY build/libs/config-service-0.0.1-SNAPSHOT.jar config.jar

ENTRYPOINT ["java", "-jar", "config.jar"]