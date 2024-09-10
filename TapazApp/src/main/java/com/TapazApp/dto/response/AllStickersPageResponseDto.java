package com.TapazApp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllStickersPageResponseDto {

    Long totalElements;
    Long totalPages;
    Boolean isEmpty;
    List<AllStickersResponseDto> content;

}
