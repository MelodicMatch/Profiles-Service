package univ_rouen.fr.Profiles_Service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import univ_rouen.fr.Profiles_Service.entity.UserMainProfile;

public interface UserMainProfileRepository extends MongoRepository<UserMainProfile, String> {}

