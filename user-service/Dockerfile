FROM openjdk:17

WORKDIR /tmp

COPY build/libs/user-service-0.0.1-SNAPSHOT.jar user.jar

ENTRYPOINT ["java", "-jar", "user.jar"]