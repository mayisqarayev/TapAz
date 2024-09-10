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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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

    public AllStickersPageResponseDto getAllStickersByAccountIdSortByStickerPrice(AllStickersRequestDto requestDto)
    {
        Page<StickerEntity> stickerEntitiesPage = stickerRepository
                .findAll(PageRequest.of(requestDto.getPageNumber(), requestDto.getPageSize()));

        List<AllStickersResponseDto> collect = sortList(stickerEntitiesPage.getContent()).stream()
                .filter(i -> i.getFkAccountId() == requestDto.getAccountId())
                .map(stickerConverter::toAllStickersResponseDtoFromEntity)
                .collect(Collectors.toList());

        return AllStickersPageResponseDto.builder()
                .totalElements(stickerEntitiesPage.getTotalElements())
                .totalPages((long)stickerEntitiesPage.getTotalPages())
                .isEmpty(stickerEntitiesPage.isEmpty())
                .content(collect)
                .build();
    }

    public List<StickerEntity> sortList(List<StickerEntity> list)
    {
        for (int i = 0; i < list.size(); i++) {
            for(int j = i+1; j < list.size();j++)
            {
                if(Integer.parseInt(list.get(i).getStickerPrice()) > Integer.parseInt(list.get(j).getStickerPrice()))
                {
                    StickerEntity temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }

        return list;
    }

    public List<AllStickersResponseDto> getAllStickersByAccountIdSortByDeploymentDate(String accountId)
    {
        return stickerRepository.getAllStickersByAccountIdSortByDeploymentDate(accountId).stream()
                .map(stickerConverter::toAllStickersResponseDtoFromEntity)
                .collect(Collectors.toList());
    }

    public List<AllStickersResponseDto> getAllStickersByAccountIdSortByStickerPriceDesc(String accountId)
    {
        return stickerRepository.findAllStickersByAccountIdSortByStickerPriceDesc(accountId).stream()
                .map(stickerConverter::toAllStickersResponseDtoFromEntity)
                .collect(Collectors.toList());
    }

}
