package univ_rouen.fr.Profiles_Service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "profileFields")
@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProfileField {
    @Id
    private String profileFieldId;

    private String name;
    private String desc;

    @DBRef
    private List<UserProfileField> userProfileFields;


}

