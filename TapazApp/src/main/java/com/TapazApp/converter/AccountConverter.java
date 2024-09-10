package com.TapazApp.converter;

import com.TapazApp.dto.response.AccountInfoResponseDto;
import com.TapazApp.entity.AccountEntity;
import com.TapazApp.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountConverter {

    public AccountInfoResponseDto toAccountInfoResponseDtoFromEntity(AccountEntity entity)
    {
        return AccountInfoResponseDto.builder()
                .accountName(entity.getAccountName())
                .accountPhoneNumber(entity.getAccountPhoneNumber())
                .location(entity.getLocation())
                .accountDescription(entity.getAccountDescription())
                .accountProfilePhotoUrl(entity.getAccountProfilePhotoUrl())
                .accountBannerUrl(entity.getAccountBannerUrl())
                .totalViewOfAccount(entity.getTotalViewOfAccount())
                .build();
    }


}
