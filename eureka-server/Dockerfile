FROM openjdk:17

WORKDIR /tmp

COPY build/libs/eureka-server-0.0.1-SNAPSHOT.jar eureka.jar

ENTRYPOINT ["java", "-jar", "eureka.jar"]