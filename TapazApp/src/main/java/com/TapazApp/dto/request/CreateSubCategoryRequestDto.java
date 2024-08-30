package com.TapazApp.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateSubCategoryRequestDto {

    String subCategoryName;
    String fkCategoryId;

    public CreateSubCategoryRequestDto(String subCategoryName, String fkCategoryId) {
        this.subCategoryName = subCategoryName;
        this.fkCategoryId = fkCategoryId;
    }
}
