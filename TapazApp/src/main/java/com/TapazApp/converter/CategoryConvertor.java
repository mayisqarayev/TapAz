package com.TapazApp.converter;

import com.TapazApp.dto.request.CreateCategoryRequestDto;
import com.TapazApp.dto.response.AllCategoriesResponseDto;
import com.TapazApp.entity.CategoryEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryConvertor {

    public CategoryEntity toEntityFromCreateCategoryRequestDto(CreateCategoryRequestDto requestDto)
    {
        CategoryEntity entity = new CategoryEntity();
        entity.setCategoryName(requestDto.getCategoryName());
        entity.setCategoryStatus(true);

        return entity;
    }

    public AllCategoriesResponseDto toAllCategoriesResponseDtoFromEntity(CategoryEntity entity){
        return new AllCategoriesResponseDto(entity.getCategoryName());
    }
}
