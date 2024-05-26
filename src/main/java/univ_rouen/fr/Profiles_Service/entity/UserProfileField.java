package univ_rouen.fr.Profiles_Service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userProfileFields")
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class UserProfileField {
    @Id
    private String id;

    @DBRef
    private ProfileField profileField;

    @DBRef
    private UserMainProfile user;

    private String content;


}
