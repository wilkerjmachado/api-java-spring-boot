FROM store/oracle/jdk:11

MAINTAINER Wilker de Jesus Machado

ADD /target/api-java-springboot.jar /opt/api-java-springboot.jar

EXPOSE 8080

ENTRYPOINT java -jar /opt/api-java-springboot.jar