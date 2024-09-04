package com.TapazApp.converter;

import com.TapazApp.dto.request.CreateStickerTypeRequestDto;
import com.TapazApp.dto.response.AllStickerTypesResponseDto;
import com.TapazApp.entity.StickerTypeEntity;
import com.TapazApp.service.SubCategoryService;
import org.springframework.stereotype.Service;

@Service
public class StickerTypeConverter {

    private final SubCategoryService categoryService;

    public StickerTypeConverter(SubCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public StickerTypeEntity toEntityFromCreateStickerTypeRequestDto(CreateStickerTypeRequestDto requestDto)
    {
        StickerTypeEntity entity = StickerTypeEntity.builder()
                .stickerTypeName(requestDto.getStickerTypeName())
                .stickerTypeStatus(true)
                .fkSubCategoryId(requestDto.getFkSubCategoryId())
                .build();

        return entity;
    }

    public AllStickerTypesResponseDto toAllStickerTypesResponseDtoFromEntity(StickerTypeEntity entity)
    {
        return new AllStickerTypesResponseDto(
                entity.getStickerTypeName(),
                categoryService.getSubCategoryById(entity.getFkSubCategoryId())
        );
    }

}
