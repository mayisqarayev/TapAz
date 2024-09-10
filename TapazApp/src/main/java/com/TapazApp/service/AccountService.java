package com.TapazApp.service;

import com.TapazApp.converter.AccountConverter;
import com.TapazApp.dto.response.AccountInfoResponseDto;
import com.TapazApp.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountConverter accountConverter;


    public AccountService(AccountRepository accountRepository, AccountConverter accountConverter) {
        this.accountRepository = accountRepository;
        this.accountConverter = accountConverter;
    }

    public AccountInfoResponseDto getAccountInfoById(String id)
    {
        AccountInfoResponseDto accountInfoResponseDtoFromEntity = accountConverter
                .toAccountInfoResponseDtoFromEntity(accountRepository.findById(id).get());
        updateTotalViewOfAccountById(id);

        return accountInfoResponseDtoFromEntity;
    }

    private void updateTotalViewOfAccountById(String id)
    {
        accountRepository.updateTotalViewOfAccountById(id);
    }



}
