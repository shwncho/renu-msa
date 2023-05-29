FROM openjdk:17

WORKDIR /tmp

COPY build/libs/apigateway-service-0.0.1-SNAPSHOT.jar gateway.jar

ENTRYPOINT ["java", "-jar", "gateway.jar"]