package univ_rouen.fr.Profiles_Service.service;

import univ_rouen.fr.Profiles_Service.entity.UserMainProfile;

import java.util.List;
import java.util.Optional;

public interface UserMainProfileService {
    List<UserMainProfile> getAllProfiles();
    Optional<UserMainProfile> getProfileById(String userId);
    UserMainProfile createProfile(UserMainProfile profile);
    Optional<UserMainProfile> updateProfile(String userId, UserMainProfile updatedProfile);
    void deleteProfile(String userId);
}
