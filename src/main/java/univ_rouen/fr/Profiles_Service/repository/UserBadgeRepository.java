package univ_rouen.fr.Profiles_Service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import univ_rouen.fr.Profiles_Service.entity.UserBadge;

public interface UserBadgeRepository extends MongoRepository<UserBadge, String> {}
