package com.TapazApp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllStickersResponseDto {

    String stickerName;
    String stickerPrice;
    Boolean isSelected;
    LocalDate deploymentDate;
    Boolean isNew;

}
