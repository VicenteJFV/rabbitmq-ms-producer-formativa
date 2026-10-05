package cl.duoc.rabbitmq_ms_productor;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

// Indica que esta clase será administrada por Spring
@Component
public class Sender {

    // Objeto utilizado para enviar mensajes a RabbitMQ
    private final RabbitTemplate rabbitTemplate;

    // Spring proporciona automáticamente RabbitTemplate
    public Sender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    // Método encargado de enviar un mensaje a RabbitMQ
    public void sendMessage(String message) {

        // Envía el mensaje utilizando "hello" como routing key
        rabbitTemplate.convertAndSend("hello", message);

        // Muestra en consola el mensaje enviado
        System.out.println("[✓] Mensaje enviado: " + message);
    }
}
