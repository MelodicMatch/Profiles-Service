package univ_rouen.fr.Profiles_Service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customProfileFields")
@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomProfileField {
    @Id
    private String customUserProfileFieldId;

    @DBRef
    private UserMainProfile user;

    private String name;
    private String content;


}

