package danekerscode.backend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import danekerscode.backend.enums.ChatType;
import danekerscode.backend.model.utils.DateAudit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Chat extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ChatType type;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "chat_members",
            joinColumns = @JoinColumn(name = "chat_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @JsonIgnore
    private Set<User> members;

    @OneToMany(
            mappedBy = "chat",
            cascade = CascadeType.ALL
    )
    private List<Message> messages;
}
