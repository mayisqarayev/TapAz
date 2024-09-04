package com.TapazApp.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AllSubCategoriesResponseDto {

    String subCategoryName;
    CategoryDtoForSubCategoryResponseDto category;

    public AllSubCategoriesResponseDto(String subCategoryName, CategoryDtoForSubCategoryResponseDto category) {
        this.subCategoryName = subCategoryName;
        this.category = category;
    }
}
