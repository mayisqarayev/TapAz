package com.TapazApp.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class AllStickerTypesResponseDto {

    String stickerTypeName;
    AllSubCategoriesResponseDto subCategory;

}
