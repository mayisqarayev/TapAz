package com.TapazApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class SubCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String subCategoryName;
    Boolean subCategoryStatus;

    String fkCategoryId;

    public SubCategoryEntity(String id, String subCategoryName, Boolean subCategoryStatus, String fkCategoryId) {
        this.id = id;
        this.subCategoryName = subCategoryName;
        this.subCategoryStatus = subCategoryStatus;
        this.fkCategoryId = fkCategoryId;
    }

    public SubCategoryEntity() {
    }
}
