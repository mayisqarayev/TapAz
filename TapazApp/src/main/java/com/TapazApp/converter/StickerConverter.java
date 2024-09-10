package com.TapazApp.converter;


import com.TapazApp.dto.response.AllStickersResponseDto;
import com.TapazApp.entity.StickerEntity;
import com.TapazApp.service.ParameterService;
import org.springframework.stereotype.Service;

@Service
public class StickerConverter {

    private final ParameterService parameterService;

    public StickerConverter(ParameterService parameterService) {
        this.parameterService = parameterService;
    }

    public AllStickersResponseDto toAllStickersResponseDtoFromEntity(StickerEntity entity)
    {
        return AllStickersResponseDto.builder()
                .stickerName(entity.getStickerName())
                .stickerPrice(entity.getStickerPrice())
                .isSelected(entity.getIsSelected())
                .deploymentDate(entity.getDeploymentDate())
                .isNew(parameterService.getIsNewOfParameterByStickerId(entity.getId()))
                .build();
    }


}
