package cl.duoc.rabbitmq_ms_productor;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Indica que esta clase contiene configuración de Spring
@Configuration
public class RabbitMQConfig {

    // Declara la cola que utilizará el microservicio
    @Bean
    public Queue helloQueue() {

        // Crea una cola llamada "hello"
        // false indica que la cola no es durable
        return new Queue("hello", false);
    }
}
