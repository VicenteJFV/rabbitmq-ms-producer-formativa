# rabbitmq-ms-productor

Microservicio **Productor** (Spring Boot 4.1.1 · Java 21).

Guía actual: *Exchanges, Bindings y Routing Keys* (2.1.3 Etapa 1). Expone `POST /api/messages` y publica
el mensaje en el Exchange `logs.direct` usando el campo `level` (`INFO`, `WARNING` o `ERROR`) como Routing Key.

## Ejecutar

1. Levantar RabbitMQ (`docker compose up -d` en la carpeta `rabbitmq-hello-world`).
2. Iniciar el Consumidor.
3. En este proyecto:

```bash
mvn clean package
mvn spring-boot:run
```

El Productor queda en http://localhost:8081.

## Probar (Postman o curl)

```bash
curl -X POST http://localhost:8081/api/messages \
  -H "Content-Type: application/json" \
  -d '{"level": "ERROR", "message": "No se pudo conectar a la base de datos"}'
```

Respuesta: `Mensaje enviado con Routing Key: ERROR`.

> Nota: las colas se declaran **durables** (`true`) igual que en el Consumidor. La guía muestra `false`
> en el Productor, pero si cada microservicio declara la misma cola con distinta durabilidad RabbitMQ
> rechaza la declaración (`PRECONDITION_FAILED - inequivalent arg 'durable'`).
