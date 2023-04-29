
FROM openjdk:17.0.2-jdk
VOLUME /tmp
COPY target/*.jar producer.jar
ENTRYPOINT ["java","-jar","/producer.jar"]
EXPOSE 8081

#FROM openjdk:17.0.2
##ADD target/producer-0.0.1-SNAPSHOT.jar producer.jar
##CMD ["java", "-jar", "producer.jar"]
#COPY ./ ./
#RUN mvn clean package
#ENTRYPOINT ["java", "-jar", "target/producer-0.0.1-SNAPSHOT.jar"]
#EXPOSE 8081



## select parent image
#FROM openjdk:17
#
## copy the source tree and the pom.xml to our new container
#COPY ./ ./
#
## package our application code
#RUN mvn clean package
#
## set the startup command to execute the jar
#ENTRYPOINT ["java", "-jar", "target/producer-0.0.1-SNAPSHOT.jar"]

## the first stage of our build will use a maven 3.9.0 parent image
#FROM maven:3.9.0 AS MAVEN_BUILD
## copy the pom and src code to the container
#COPY ./ ./
## package our application code
#RUN mvn clean package
## the second stage of our build will use open jdk 17 on alpine 3.9
#FROM openjdk:17
## copy only the artifacts we need from the first stage and discard the rest
#COPY --from=MAVEN_BUILD /target/producer-0.0.1-SNAPSHOT.jar /producer.jar
## set the startup command to execute the jar
#CMD ["java", "-jar", "/producer.jar"]

## select parent image
#FROM maven:3.9.0
#
## copy the source tree and the pom.xml to our new container
#COPY ./ ./
#
## package our application code
#RUN mvn clean package
#
## set the startup command to execute the jar
#CMD ["java", "-jar", "target/producer-0.0.1-SNAPSHOT.jar"]