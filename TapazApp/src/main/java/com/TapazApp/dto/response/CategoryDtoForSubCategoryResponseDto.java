package com.TapazApp.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryDtoForSubCategoryResponseDto {

    String categoryName;

    public CategoryDtoForSubCategoryResponseDto(String categoryName) {
        this.categoryName = categoryName;
    }
}
