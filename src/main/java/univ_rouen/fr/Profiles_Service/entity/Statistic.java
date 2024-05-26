package univ_rouen.fr.Profiles_Service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "statistics")
public class Statistic {
    @Id
    private String statisticId;

    private String name;
    private String desc;

    @DBRef
    private List<UserStatistic> userStatistics;

    @DBRef
    private List<Badge> badges;


}

