package danekerscode.backend.model.utils;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

@MappedSuperclass
public class DateAudit {

    @Column(updatable = false, nullable = false)
    private LocalDateTime createdTime;

    @Column( nullable = false)
    private LocalDateTime lastUpdateTime;

    @PrePersist
    private void prePersist(){
        this.createdTime = LocalDateTime.now();
        this.lastUpdateTime = createdTime;
    }

    private void preUpdate(){
        this.lastUpdateTime = LocalDateTime.now();
    }


}
