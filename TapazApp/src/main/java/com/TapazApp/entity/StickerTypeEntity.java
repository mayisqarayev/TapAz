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
public class StickerTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String stickerTypeName;
    Boolean stickerTypeStatus;

    String fkSubCategoryId;

    public StickerTypeEntity(String id, String stickerTypeName, Boolean stickerTypeStatus, String fkSubCategoryId) {
        this.id = id;
        this.stickerTypeName = stickerTypeName;
        this.stickerTypeStatus = stickerTypeStatus;
        this.fkSubCategoryId = fkSubCategoryId;
    }

    public StickerTypeEntity() {
    }
}
