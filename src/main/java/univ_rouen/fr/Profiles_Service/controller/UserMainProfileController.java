package univ_rouen.fr.Profiles_Service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import univ_rouen.fr.Profiles_Service.entity.UserMainProfile;
import univ_rouen.fr.Profiles_Service.service.KafkaService;
import univ_rouen.fr.Profiles_Service.service.UserMainProfileService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profiles")
@AllArgsConstructor
@Tag(name = "Profiles API", description = "API pour la gestion des profils utilisateur")
public class UserMainProfileController {

    private final UserMainProfileService userMainProfileService;
    private final KafkaService kafkaService;

    @Operation(summary = "Obtenir tous les profils", description = "Récupérer une liste de tous les profils utilisateur")
    @GetMapping
    public ResponseEntity<List<UserMainProfile>> getAllProfiles() {
        List<UserMainProfile> profiles = userMainProfileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }

    @Operation(summary = "Obtenir un profil par ID", description = "Récupérer un profil utilisateur par son ID")
    @GetMapping("/{userId}")
    public ResponseEntity<UserMainProfile> getProfileById(@PathVariable String userId) {
        Optional<UserMainProfile> profile = userMainProfileService.getProfileById(userId);
        return profile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Créer un nouveau profil", description = "Créer un nouveau profil utilisateur")
    @PostMapping("/new")
    public ResponseEntity<UserMainProfile> createProfile(@RequestBody UserMainProfile profile) {
        UserMainProfile createdProfile = userMainProfileService.createProfile(profile);
        kafkaService.sendMessage("New profile created: " + profile.getUserId());
        return ResponseEntity.ok(createdProfile);
    }

    @Operation(summary = "Mettre à jour un profil", description = "Mettre à jour un profil utilisateur existant")
    @PutMapping("/update/{userId}")
    public ResponseEntity<UserMainProfile> updateProfile(@PathVariable String userId, @RequestBody UserMainProfile updatedProfile) {
        Optional<UserMainProfile> updated = userMainProfileService.updateProfile(userId, updatedProfile);
        updated.ifPresent(profile -> kafkaService.sendMessage("Profile updated: " + profile.getUserId()));
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Supprimer un profil", description = "Supprimer un profil utilisateur par son ID")
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteProfile(@PathVariable String userId) {
        userMainProfileService.deleteProfile(userId);
        kafkaService.sendMessage("Profile deleted: " + userId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Afficher les détails du profil", description = "Afficher les détails d'un profil utilisateur")
    @GetMapping("/details/{userId}")
    public ResponseEntity<UserMainProfile> viewProfileDetails(@PathVariable String userId) {
        Optional<UserMainProfile> profile = userMainProfileService.getProfileById(userId);
        return profile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Envoyer un message Kafka", description = "Envoyer un message Kafka de test")
    @GetMapping("/send-kafka-message")
    public ResponseEntity<String> sendKafkaMessage(@RequestParam String message) {
        kafkaService.sendMessage(message);
        return ResponseEntity.ok("Message sent: " + message);
    }
}
