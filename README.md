
# Observabiltiy - Microservice - Auth Service

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

# TODO
* liquibase
* security
* opentelemetry + otel collector
* redis
* kafka
