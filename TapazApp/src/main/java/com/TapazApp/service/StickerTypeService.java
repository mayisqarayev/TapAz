package com.TapazApp.service;

import com.TapazApp.converter.StickerTypeConverter;
import com.TapazApp.dto.request.CreateStickerTypeRequestDto;
import com.TapazApp.dto.response.AllStickerTypesResponseDto;
import com.TapazApp.repository.StickerTypeRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StickerTypeService {

    private final StickerTypeRepository stickerTypeRepository;
    private final StickerTypeConverter stickerTypeConverter;

    public StickerTypeService(StickerTypeRepository stickerTypeRepository, StickerTypeConverter stickerTypeConverter) {
        this.stickerTypeRepository = stickerTypeRepository;
        this.stickerTypeConverter = stickerTypeConverter;
    }

    public void createStickerType(CreateStickerTypeRequestDto createStickerTypeRequestDto)
    {
        stickerTypeRepository.save(stickerTypeConverter.toEntityFromCreateStickerTypeRequestDto(createStickerTypeRequestDto));
    }

    public List<AllStickerTypesResponseDto> getAllStickerTypesBySubCategoryId(String subCategoryId)
    {
        return stickerTypeRepository.findAll().stream()
                .filter(i -> i.getFkSubCategoryId() == subCategoryId)
                .map(stickerTypeConverter::toAllStickerTypesResponseDtoFromEntity)
                .collect(Collectors.toList());
    }

    public void deleteStickerTypeById(String id)
    {
        stickerTypeRepository.deleteStickerTypeById(id);
    }

}
