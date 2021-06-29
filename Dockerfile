FROM openjdk:8

USER root

ADD target/desafio*.jar desafio.jar

COPY datacom.com.br /home/datacom.com.br

RUN keytool -list -v -keystore /usr/local/openjdk-8/jre/lib/security/cacerts  > java_cacerts.txt

RUN keytool -import -noprompt -trustcacerts -alias example -keystore /usr/local/openjdk-8/jre/lib/security/cacerts -file /home/datacom.com.br -storepass changeit

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "desafio.jar"]
