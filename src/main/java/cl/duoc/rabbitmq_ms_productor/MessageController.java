package cl.duoc.rabbitmq_ms_productor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Indica que esta clase expone servicios REST
@RestController

// Define la ruta base del endpoint
@RequestMapping("/api/messages")
public class MessageController {

    // Componente encargado de enviar el mensaje a RabbitMQ
    private final Sender sender;

    // Spring proporciona automáticamente el componente Sender
    public MessageController(Sender sender) {
        this.sender = sender;
    }

    // Endpoint HTTP POST para enviar un mensaje
    @PostMapping
    public ResponseEntity<String> sendMessage(
            @RequestBody MessageRequest request) {

        // Envía el mensaje recibido hacia RabbitMQ
        sender.sendMessage(request.message());

        // Devuelve una respuesta indicando que el mensaje fue enviado
        return ResponseEntity.ok(
                "Mensaje enviado: " + request.message());
    }

    // Representa el cuerpo JSON recibido desde la solicitud HTTP
    public record MessageRequest(String message) {
    }
}
