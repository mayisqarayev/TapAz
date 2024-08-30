package com.TapazApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Builder
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String accountName;
    Boolean accountStatus;
    String accountPhoneNumber;
    String location;
    String accountDescription;
    String accountProfilePhotoUrl;
    String accountBannerUrl;
    BigDecimal totalViewOfAccount;

    String fkUserId;

    public AccountEntity(String id, String accountName, Boolean accountStatus, String accountPhoneNumber, String location, String accountDescription, String accountProfilePhotoUrl, String accountBannerUrl, BigDecimal totalViewOfAccount, String fkUserId) {
        this.id = id;
        this.accountName = accountName;
        this.accountStatus = accountStatus;
        this.accountPhoneNumber = accountPhoneNumber;
        this.location = location;
        this.accountDescription = accountDescription;
        this.accountProfilePhotoUrl = accountProfilePhotoUrl;
        this.accountBannerUrl = accountBannerUrl;
        this.totalViewOfAccount = totalViewOfAccount;
        this.fkUserId = fkUserId;
    }

    public AccountEntity() {
    }
}
