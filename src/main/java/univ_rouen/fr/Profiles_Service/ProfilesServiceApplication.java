package univ_rouen.fr.Profiles_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import univ_rouen.fr.Profiles_Service.entity.*;
import univ_rouen.fr.Profiles_Service.service.UserMainProfileService;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ProfilesServiceApplication implements CommandLineRunner {

	@Autowired
	private UserMainProfileService userMainProfileService;

	public static void main(String[] args) {
		SpringApplication.run(ProfilesServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Gender male = new Gender("1", "Male", List.of());
		Gender female = new Gender("2", "Female", List.of());

		Orientation straight = new Orientation("1", "Straight", List.of());
		Orientation gay = new Orientation("2", "Gay", List.of());

		// Créez d'autres objets nécessaires

		UserMainProfile user1 = UserMainProfile.builder()
				.userId("user1")
				.birthDate(new Date())
				.location("Paris")
				.gender(male)
				.orientation(straight)
				// Ajoutez d'autres champs nécessaires
				.build();

		UserMainProfile user2 = UserMainProfile.builder()
				.userId("user2")
				.birthDate(new Date())
				.location("Lyon")
				.gender(female)
				.orientation(gay)
				// Ajoutez d'autres champs nécessaires
				.build();

		userMainProfileService.createProfile(user1);
		userMainProfileService.createProfile(user2);

		System.out.println("Users created successfully.");*/
	}
}