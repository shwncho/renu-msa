FROM openjdk:17

WORKDIR /tmp

COPY build/libs/authentication-0.0.1-SNAPSHOT.jar authentication.jar

ENTRYPOINT ["java", "-jar", "authentication.jar"]