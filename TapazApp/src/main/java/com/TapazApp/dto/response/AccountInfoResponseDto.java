package com.TapazApp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountInfoResponseDto {

    String accountName;
    String accountPhoneNumber;
    String location;
    String accountDescription;
    String accountProfilePhotoUrl;
    String accountBannerUrl;
    BigDecimal totalViewOfAccount;


}
