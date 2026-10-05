# rabbitmq-ms-productor

Microservicio **Productor** de la guía *Hello World con RabbitMQ* (Spring Boot 4.1.1 · Java 21).
Expone `POST /api/messages` y publica el mensaje en la cola `hello` usando `RabbitTemplate`.

## Ejecutar

1. Levantar RabbitMQ (`docker compose up -d` en la carpeta `rabbitmq-hello-world`).
2. En este proyecto:

```bash
mvn clean package
mvn spring-boot:run
```

El Productor queda en http://localhost:8081.

## Probar (Postman o curl)

```bash
curl -X POST http://localhost:8081/api/messages \
  -H "Content-Type: application/json" \
  -d '{"message": "Hello World desde RabbitMQ!"}'
```

En la consola debe aparecer `[✓] Mensaje enviado: Hello World desde RabbitMQ!`.
