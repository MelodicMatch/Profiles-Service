package univ_rouen.fr.Profiles_Service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "genders")
@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Gender {
    @Id
    private String genderId;

    private String name;

    @DBRef
    private List<UserMainProfile> users;


}
