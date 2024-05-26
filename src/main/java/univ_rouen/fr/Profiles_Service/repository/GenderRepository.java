package univ_rouen.fr.Profiles_Service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import univ_rouen.fr.Profiles_Service.entity.Gender;

public interface GenderRepository extends MongoRepository<Gender, String> {}