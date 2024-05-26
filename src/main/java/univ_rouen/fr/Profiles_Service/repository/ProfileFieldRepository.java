package univ_rouen.fr.Profiles_Service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import univ_rouen.fr.Profiles_Service.entity.ProfileField;

public interface ProfileFieldRepository extends MongoRepository<ProfileField, String> {}
