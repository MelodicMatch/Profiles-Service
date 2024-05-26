package univ_rouen.fr.Profiles_Service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userStatistics")
@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class UserStatistic {
    @Id
    private String id;

    @DBRef
    private UserMainProfile user;

    @DBRef
    private Statistic statistic;

    private Integer value;


}

