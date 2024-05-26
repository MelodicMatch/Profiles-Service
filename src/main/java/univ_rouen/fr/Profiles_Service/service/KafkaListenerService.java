package univ_rouen.fr.Profiles_Service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaListenerService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "user-profiles", groupId = "profiles-group")
    public void listen(String message) {
        try {
            GenreMessage genreMessage = objectMapper.readValue(message, GenreMessage.class);
            log.info("Received message: Nouveau genre créé : ID = {}, Nom = {}", genreMessage.id, genreMessage.name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class GenreMessage {
        public String id;
        public String name;
    }
}
