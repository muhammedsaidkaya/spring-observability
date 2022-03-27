
# Observabiltiy - Spring Boot APP - Auth Service

## Components
* Opentracing Agent - Instrumentation
* Jaeger - Tracing
* Zipkin - Tracing
* Spring Security
* Spring Data JPA
* Spring Web
* PostgreSQL
* Redis - Caching
* Kafka - Queue - Event
* Transactional Logging - Debezium - Event Publish
* Choreography Saga Pattern
* ELK Stack - Logging
* Event Sourcing
* Opentelemetry & Prometheus Exporter (Instrumentation) + Prometheus - Metric
* Grafana
* Zabbix

# JAR
```
./mvnw clean package -DskipTests
```

# DOCKER-BUILD
```
docker buildx build --platform linux/amd64 . -t uzumlukek/auth-service:testing
```

# DOCKER-COMPOSE
```
docker-compose up --build
```

# REGISTER - EXAMPLE
```
curl --location --request POST 'http://localhost:9090/api/v1.0/person/register' \
--header 'Content-Type: application/json' \
--data-raw '{
    "identificationNumber": "11111111110",
    "email": "saidkaya@gmail.com",
    "password": "password",
    "name": "Said Kaya",
    "address": "Adress",
    "phone": "Phone"
}'
```

# Jaeger
```
docker run -d --name jaeger -p 16686:16686 -p 6831:6831/udp jaegertracing/all-in-one:1.9
```

# Zipkin
```
docker run -d -p 9411:9411 openzipkin/zipkin
```

# Postgres
```
docker run --name some-postgres -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 postgres
```

# Redis
```
docker run --name redis -d -p 6379:6379 redis
```

# Kafka
```
cd kafka_2.13-3.1.0

bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties

bin/kafka-topics.sh --create --topic my-topic --bootstrap-server localhost:9092
bin/kafka-topics.sh --describe --topic my-topic --bootstrap-server localhost:9092 

bin/kafka-console-producer.sh --topic my-topic --bootstrap-server localhost:9092
bin/kafka-console-consumer.sh --topic my-topic --from-beginning --bootstrap-server localhost:9092

or docker-case

//Add kafka container id to your hosts
echo "127.0.0.1 7f4655d8fbb3" >> /etc/hosts
```

# ELK STACK
```
docker-compose -f elk-compose.yml up -d 
```

# DONE
* Postgres
* Spring Web
* Spring Data JPA
* OpenTracing Agent - Instrumentation
* Jaeger - Span Reporting
* Redis Caching
* Kafka Producer Consumer - Publish Event

# TODO
* liquibase - db data
* security - authentication mechanism
* fix zipkin integration
* dockerize application
* Transactional Logging - Debezium - Event Publish
* Choreography Saga Pattern
* ELK Stack - Logging
* Event Sourcing
* Opentelemetry & Prometheus Exporter (Instrumentation) + Prometheus - Metric
* Grafana
* Zabbix
