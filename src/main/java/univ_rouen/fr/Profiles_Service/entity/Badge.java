package univ_rouen.fr.Profiles_Service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "badges")
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class Badge {
    @Id
    private String badgeId;

    @DBRef
    private Statistic statistic;

    private Integer target;
    private String name;
    private String desc;

    @DBRef
    private List<UserBadge> userBadges;


}

