package univ_rouen.fr.Profiles_Service.service;

public interface KafkaService {
    void sendMessage(String message);
    void consumeMessage(String message);
}
