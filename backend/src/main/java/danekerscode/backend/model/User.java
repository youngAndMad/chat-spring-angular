package danekerscode.backend.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import danekerscode.backend.enums.Gender;
import danekerscode.backend.model.utils.DateAudit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class User  extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private Gender gender;
    private String email;
    @JsonIgnore
    private String password;
    private LocalDateTime registeredTime;

    @ManyToMany
    @JoinTable(
            name = "chat_members",
            inverseJoinColumns = @JoinColumn(name = "chat_id"),
            joinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Chat> chats;

    @OneToMany(
            mappedBy = "sender",
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private List<Message> messages;
}
