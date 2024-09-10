package com.TapazApp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllStickersRequestDto {

    Integer pageNumber;
    Integer pageSize;
    String accountId;

}
