package univ_rouen.fr.Profiles_Service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userSocialMedias")
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class UserSocialMedia {
    @Id
    private String id;

    @DBRef
    private UserMainProfile user;

    @DBRef
    private SocialMedia socialMedia;

    private String profileLink;
    private Boolean authorization;


}
