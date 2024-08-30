package com.TapazApp.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AllCategoriesResponseDto {
    String categoryName;

    public AllCategoriesResponseDto(String categoryName) {
        this.categoryName = categoryName;
    }
}
