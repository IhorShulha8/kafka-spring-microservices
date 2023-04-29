
How to run a project:
---------------------
for each microservice (producer, consumer)
>mvn clean install

run kafka, zookeeper by docker compose file from root directory
>docker compose up -d 
 
go to producer folder and run producer-microservice
> java -jar target/producer-0.0.1-SNAPSHOT.jar

go to consumer folder and run consumer-microservice
> java -jar target/consumer-0.0.1-SNAPSHOT.jar

Make an foodOrder 
open POSTMAN http://localhost:8081/orders and make a POST request with body:
{
"item" : "some item",
"amount" : "some amount"
}

or by curl
> curl --location 'http://localhost:8081/orders' \
> --header 'Accept: application/json' \
> --header 'Content-Type: application/json' \
> --data '{"item" : "burger","amount" : "1"}'

## H2 DB (received orders stored in H2 DB)
> http://localhost:8082/h2-console
> username: sa
> password: password
> jdbc url: jdbc:h2:mem:test


## Kafka Cluster Overview (UI for viewing Kafka topics and browsing consumer groups)
> http://localhost:9000

