package com.TapazApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Builder
public class StickerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String stickerName;
    String stickerPrice;
    Boolean isSelected;
    String stickerDescription;
    BigDecimal numberOfSticker;
    LocalDate deploymentDate;
    BigDecimal countOfView;
    Boolean stickerStatus;

    String fkStickerTypeId;
    String fkAccountId;
    String fkParameterId;

    public StickerEntity(String id, String stickerName, String stickerPrice, Boolean isSelected, String stickerDescription, BigDecimal numberOfSticker, LocalDate deploymentDate, BigDecimal countOfView, Boolean stickerStatus, String fkStickerTypeId, String fkAccountId, String fkParameterId) {
        this.id = id;
        this.stickerName = stickerName;
        this.stickerPrice = stickerPrice;
        this.isSelected = isSelected;
        this.stickerDescription = stickerDescription;
        this.numberOfSticker = numberOfSticker;
        this.deploymentDate = deploymentDate;
        this.countOfView = countOfView;
        this.stickerStatus = stickerStatus;
        this.fkStickerTypeId = fkStickerTypeId;
        this.fkAccountId = fkAccountId;
        this.fkParameterId = fkParameterId;
    }

    public StickerEntity() {
    }
}
