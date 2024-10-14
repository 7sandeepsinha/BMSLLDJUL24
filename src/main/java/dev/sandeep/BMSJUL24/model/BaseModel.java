package dev.sandeep.BMSJUL24.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @CreatedDate // tells JPA to insert current time when row is created
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;
    @LastModifiedDate // tells JPA to insert last modification time for the row
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;
}
//There are some fields which would be common across all the models
// id
// createdAt
// updatedAt
