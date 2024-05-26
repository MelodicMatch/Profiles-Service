package univ_rouen.fr.Profiles_Service.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import univ_rouen.fr.Profiles_Service.entity.UserMainProfile;
import univ_rouen.fr.Profiles_Service.repository.UserMainProfileRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserMainProfileServiceImpl implements UserMainProfileService {

    private final UserMainProfileRepository userMainProfileRepository;

    @Override
    public List<UserMainProfile> getAllProfiles() {
        return userMainProfileRepository.findAll();
    }

    @Override
    public Optional<UserMainProfile> getProfileById(String userId) {
        return userMainProfileRepository.findById(userId);
    }

    @Override
    public UserMainProfile createProfile(UserMainProfile profile) {
        return userMainProfileRepository.save(profile);
    }

    @Override
    public Optional<UserMainProfile> updateProfile(String userId, UserMainProfile updatedProfile) {
        return userMainProfileRepository.findById(userId)
                .map(existingProfile -> {
                    existingProfile.setBirthDate(updatedProfile.getBirthDate());
                    existingProfile.setLocation(updatedProfile.getLocation());
                    existingProfile.setGender(updatedProfile.getGender());
                    existingProfile.setOrientation(updatedProfile.getOrientation());
                    existingProfile.setProfileFields(updatedProfile.getProfileFields());
                    existingProfile.setCustomProfileFields(updatedProfile.getCustomProfileFields());
                    existingProfile.setUserStatistics(updatedProfile.getUserStatistics());
                    existingProfile.setUserSocialMedias(updatedProfile.getUserSocialMedias());
                    existingProfile.setUserBadges(updatedProfile.getUserBadges());
                    return userMainProfileRepository.save(existingProfile);
                });
    }

    @Override
    public void deleteProfile(String userId) {
        userMainProfileRepository.deleteById(userId);
    }
}
