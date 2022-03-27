
# Observabiltiy - Spring Boot APP - Auth Service

# Run (Check run.png - Dev Profile)

## Postgres
```
docker run --name some-postgres -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 postgres
```
## Jaeger & Zipkin - If opentracing.enabled=true
```
docker run -d --name jaeger -p 16686:16686 -p 6831:6831/udp jaegertracing/all-in-one:1.9
docker run -d -p 9411:9411 openzipkin/zipkin
```
## Redis - If spring.cache.type=redis
```
docker run --name redis -d -p 6379:6379 redis
```

## Components
* Opentracing Agent - Instrumentation
* Jaeger - Tracing
* Zipkin - Tracing
* Spring Security
* Spring Data JPA
* Spring Web
* PostgreSQL
* Redis - Caching
* EFK Stack - Logging
* Event Sourcing
* Opentelemetry & Prometheus Exporter (Instrumentation) + Prometheus - Metric
* Grafana
* Zabbix

# JAR
```
./mvnw clean package -DskipTests
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

# DONE
* Postgres
* Spring Web
* Spring Data JPA
* OpenTracing Agent - Instrumentation
* Jaeger - Span Reporting
* Redis Caching

# TODO
* liquibase - db data
* security - authentication mechanism
* fix zipkin integration
* dockerize application
* EFK Stack - Logging
* Event Sourcing
* Opentelemetry & Prometheus Exporter (Instrumentation) + Prometheus - Metric
* Grafana
* Zabbix
