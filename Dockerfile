FROM openjdk:8

ADD target/desafio*.jar desafio.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "desafio.jar"]
