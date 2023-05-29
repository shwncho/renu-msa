FROM openjdk:17

WORKDIR /tmp

COPY build/libs/nutrient-service-0.0.1-SNAPSHOT.jar nutrient.jar

ENTRYPOINT ["java", "-jar", "nutrient.jar"]