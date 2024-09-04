package com.TapazApp.converter;

import com.TapazApp.dto.request.CreateSubCategoryRequestDto;
import com.TapazApp.dto.response.AllSubCategoriesResponseDto;
import com.TapazApp.entity.SubCategoryEntity;
import com.TapazApp.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryConverter {

    private final CategoryService categoryService;

    public SubCategoryConverter(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public SubCategoryEntity toEntityFromCreateSubCategoryRequestDto(CreateSubCategoryRequestDto requestDto)
    {
        SubCategoryEntity entity = new SubCategoryEntity();
        entity.setSubCategoryName(requestDto.getSubCategoryName());
        entity.setFkCategoryId(requestDto.getFkCategoryId());

        return entity;
    }

    public AllSubCategoriesResponseDto toAllSubCategoriesByCategoryIdFromEntity(SubCategoryEntity entity)
    {
        return new AllSubCategoriesResponseDto(
                entity.getSubCategoryName(),
                categoryService.getCategoryById(entity.getFkCategoryId())
        );
    }
}
