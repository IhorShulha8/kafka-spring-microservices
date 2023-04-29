FROM openjdk:17.0.2-jdk
VOLUME /tmp
COPY target/*.jar consumer.jar
ENTRYPOINT ["java","-jar","/consumer.jar"]
#ENTRYPOINT ["java","-jar","/consumer.jar", "-web -webAllowOthers -tcp -tcpAllowOthers -browser"]
EXPOSE 8082
