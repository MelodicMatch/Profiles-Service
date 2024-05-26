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
@Tag(name = "Profiles API", description = "API for managing user profiles")
public class UserMainProfileController {

    private final UserMainProfileService userMainProfileService;
    private final KafkaService kafkaService;

    @Operation(summary = "Get all profiles", description = "Retrieve a list of all user profiles")
    @GetMapping
    public ResponseEntity<List<UserMainProfile>> getAllProfiles() {
        List<UserMainProfile> profiles = userMainProfileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }

    @Operation(summary = "Get profile by ID", description = "Retrieve a user profile by its ID")
    @GetMapping("/{userId}")
    public ResponseEntity<UserMainProfile> getProfileById(@PathVariable String userId) {
        Optional<UserMainProfile> profile = userMainProfileService.getProfileById(userId);
        return profile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create new profile", description = "Create a new user profile")
    @PostMapping("/new")
    public ResponseEntity<UserMainProfile> createProfile(@RequestBody UserMainProfile profile) {
        UserMainProfile createdProfile = userMainProfileService.createProfile(profile);
        kafkaService.sendMessage("New profile created: " + profile.getUserId());
        return ResponseEntity.ok(createdProfile);
    }

    @Operation(summary = "Update profile", description = "Update an existing user profile")
    @PutMapping("/update/{userId}")
    public ResponseEntity<UserMainProfile> updateProfile(@PathVariable String userId, @RequestBody UserMainProfile updatedProfile) {
        Optional<UserMainProfile> updated = userMainProfileService.updateProfile(userId, updatedProfile);
        updated.ifPresent(profile -> kafkaService.sendMessage("Profile updated: " + profile.getUserId()));
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete profile", description = "Delete a user profile by its ID")
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteProfile(@PathVariable String userId) {
        userMainProfileService.deleteProfile(userId);
        kafkaService.sendMessage("Profile deleted: " + userId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "View profile details", description = "View the details of a user profile")
    @GetMapping("/details/{userId}")
    public ResponseEntity<UserMainProfile> viewProfileDetails(@PathVariable String userId) {
        Optional<UserMainProfile> profile = userMainProfileService.getProfileById(userId);
        return profile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Send Kafka message", description = "Send a test Kafka message")
    @GetMapping("/send-kafka-message")
    public ResponseEntity<String> sendKafkaMessage(@RequestParam String message) {
        kafkaService.sendMessage(message);
        return ResponseEntity.ok("Message sent: " + message);
    }


}
