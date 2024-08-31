package com.TapazApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SelectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    Boolean selectStatus;

    String fkUserId;
    String fkStickerId;

    public SelectEntity() {
    }

    public SelectEntity(String id, Boolean selectStatus, String fkUserId, String fkStickerId) {
        this.id = id;
        this.selectStatus = selectStatus;
        this.fkUserId = fkUserId;
        this.fkStickerId = fkStickerId;
    }
}
