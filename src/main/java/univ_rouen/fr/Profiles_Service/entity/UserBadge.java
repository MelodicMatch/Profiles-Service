package univ_rouen.fr.Profiles_Service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "userBadges")
public class UserBadge {
    @Id
    private String id;

    @DBRef
    private Badge badge;

    @DBRef
    private UserMainProfile user;

    private Date date;
    private Boolean displayed;


}
