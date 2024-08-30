package com.TapazApp.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE )
@Data
public class CreateCategoryRequestDto {
    String categoryName;

    public CreateCategoryRequestDto(String categoryName) {
        this.categoryName = categoryName;
    }
}
