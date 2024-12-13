FROM openjdk:17
EXPOSE 8081
COPY build/libs/prices-data-0.0.1-SNAPSHOT.jar prices-data.jar
ENTRYPOINT ["java", "-jar", "/prices-data.jar"]