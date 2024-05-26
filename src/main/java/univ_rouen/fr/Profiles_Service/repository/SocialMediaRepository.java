package univ_rouen.fr.Profiles_Service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import univ_rouen.fr.Profiles_Service.entity.SocialMedia;

public interface SocialMediaRepository extends MongoRepository<SocialMedia, String> {}
