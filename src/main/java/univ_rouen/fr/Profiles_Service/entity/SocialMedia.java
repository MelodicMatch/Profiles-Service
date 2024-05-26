package univ_rouen.fr.Profiles_Service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "socialMedias")
public class SocialMedia {
    @Id
    private String socialMediaId;

    private String name;
    private String url;

    @DBRef
    private List<UserSocialMedia> userSocialMedias;


}
