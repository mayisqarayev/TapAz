package com.TapazApp.service;

import com.TapazApp.converter.StickerConverter;
import com.TapazApp.dto.request.AllStickersRequestDto;
import com.TapazApp.dto.response.AllStickersPageResponseDto;
import com.TapazApp.dto.response.AllStickersResponseDto;
import com.TapazApp.entity.StickerEntity;
import com.TapazApp.repository.StickerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StickerService {

    private final StickerRepository stickerRepository;
    private final StickerConverter stickerConverter;

    public StickerService(StickerRepository stickerRepository, StickerConverter stickerConverter) {
        this.stickerRepository = stickerRepository;
        this.stickerConverter = stickerConverter;
    }

    public BigDecimal getCountOfStickersByAccountId(String accountId)
    {
        return stickerRepository.findCountOfStickersByAccountId(accountId);
    }

    public List<AllStickersResponseDto> getAllStickersByAccountId(String accountId)
    {
        return stickerRepository.findAll().stream()
                .filter(i -> i.getFkAccountId() == accountId)
                .map(stickerConverter::toAllStickersResponseDtoFromEntity)
                .collect(Collectors.toList());
    }

    public AllStickersPageResponseDto getAllStickersByAccountIdSortByStickerPricePg(AllStickersRequestDto requestDto)
    {
        Page<StickerEntity> stickerEntitiesPage = stickerRepository
                .findAll(PageRequest.of(requestDto.getPageNumber(), requestDto.getPageSize()));

        List<StickerEntity> content = stickerEntitiesPage.getContent();

        content.sort((i, j) -> Integer.compare(
                        Integer.parseInt(i.getStickerPrice()),
                        Integer.parseInt(j.getStickerPrice()))
        );

        List<AllStickersResponseDto> collect = content.stream().filter(i -> i.getFkAccountId() == requestDto.getAccountId())
                .map(stickerConverter::toAllStickersResponseDtoFromEntity)
                .collect(Collectors.toList());

        return AllStickersPageResponseDto.builder()
                .totalElements(stickerEntitiesPage.getTotalElements())
                .totalPages((long)stickerEntitiesPage.getTotalPages())
                .isEmpty(stickerEntitiesPage.isEmpty())
                .content(collect)
                .build();
    }

    public List<AllStickersResponseDto> getAllStickersByAccountIdSortByStickerPrice(String accountId)
    {
        return stickerRepository.findAllStickersByAccountIdSortByStickerPrice(accountId).stream()
                .map(stickerConverter::toAllStickersResponseDtoFromEntity)
                .collect(Collectors.toList());
    }

    public AllStickersPageResponseDto getAllStickersByAccountIdSortByDeploymentDatePg(AllStickersRequestDto requestDto)
    {
        Page<StickerEntity> stickerEntitiesPage = stickerRepository
                .findAll(PageRequest.of(requestDto.getPageNumber(), requestDto.getPageSize()));

        List<StickerEntity> content = stickerEntitiesPage.getContent();

        content.sort(Comparator.comparing(StickerEntity::getDeploymentDate));

        List<AllStickersResponseDto> collect = content.stream()
                .map(stickerConverter::toAllStickersResponseDtoFromEntity)
                .collect(Collectors.toList());

        return AllStickersPageResponseDto.builder()
                .totalElements(stickerEntitiesPage.getTotalElements())
                .totalPages((long)stickerEntitiesPage.getTotalPages())
                .isEmpty(stickerEntitiesPage.isEmpty())
                .content(collect)
                .build();
    }

    public List<AllStickersResponseDto> getAllStickersByAccountIdSortByDeploymentDate(String accountId)
    {
        return stickerRepository.findAllStickersByAccountIdSortByDeploymentDate(accountId).stream()
                .map(stickerConverter::toAllStickersResponseDtoFromEntity)
                .collect(Collectors.toList());
    }

    public AllStickersPageResponseDto getAllStickersByAccountIdSortByStickerPriceDescPg(AllStickersRequestDto requestDto)
    {
        Page<StickerEntity> stickerEntitiesPage = stickerRepository
                .findAll(PageRequest.of(requestDto.getPageNumber(), requestDto.getPageSize()));

        List<StickerEntity> content = stickerEntitiesPage.getContent();

        content.sort((i, j) -> Integer.compare(
                Integer.parseInt(i.getStickerPrice()),
                Integer.parseInt(i.getStickerPrice())
        ));
        Collections.reverse(content);

        List<AllStickersResponseDto> collect = content.stream()
                .map(stickerConverter::toAllStickersResponseDtoFromEntity)
                .collect(Collectors.toList());

        return AllStickersPageResponseDto.builder()
                .totalElements(stickerEntitiesPage.getTotalElements())
                .totalPages((long)stickerEntitiesPage.getTotalPages())
                .isEmpty(stickerEntitiesPage.isEmpty())
                .content(collect)
                .build();
    }

    public List<AllStickersResponseDto> getAllStickersByAccountIdSortByStickerPriceDesc(String accountId)
    {
        return stickerRepository.findAllStickersByAccountIdSortByStickerPriceDesc(accountId).stream()
                .map(stickerConverter::toAllStickersResponseDtoFromEntity)
                .collect(Collectors.toList());
    }


}
