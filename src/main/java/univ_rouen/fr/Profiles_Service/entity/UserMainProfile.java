package univ_rouen.fr.Profiles_Service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "userMainProfiles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class UserMainProfile {
    @Id
    private String userId;

    private Date birthDate;
    private String location;

    @DBRef
    private Gender gender;

    @DBRef
    private Orientation orientation;

    @DBRef
    private List<UserProfileField> profileFields;

    @DBRef
    private List<CustomProfileField> customProfileFields;

    @DBRef
    private List<UserStatistic> userStatistics;

    @DBRef
    private List<UserSocialMedia> userSocialMedias;

    @DBRef
    private List<UserBadge> userBadges;


}
