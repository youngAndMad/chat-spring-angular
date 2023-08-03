package danekerscode.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import danekerscode.backend.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User{
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
}
