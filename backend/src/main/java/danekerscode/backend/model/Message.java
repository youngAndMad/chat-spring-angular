package danekerscode.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import danekerscode.backend.model.utils.DateAudit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class Message extends DateAudit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String value;
    @ManyToOne
    @JsonIgnore
    private Chat chat;
    @ManyToOne
    private User sender;
}
