package com.TapazApp.service;

import com.TapazApp.converter.SubCategoryConverter;
import com.TapazApp.dto.request.CreateSubCategoryRequestDto;
import com.TapazApp.dto.response.AllSubCategoriesByCategoryId;
import com.TapazApp.repository.SubCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService {

    private final SubCategoryRepository categoryRepository;
    private final SubCategoryConverter subCategoryConverter;

    public SubCategoryService(SubCategoryRepository categoryRepository, SubCategoryConverter subCategoryConverter) {
        this.categoryRepository = categoryRepository;
        this.subCategoryConverter = subCategoryConverter;
    }

    public void createSubCategory(CreateSubCategoryRequestDto createSubCategoryRequestDto)
    {
        categoryRepository.save(subCategoryConverter.toEntityFromCreateSubCategoryRequestDto(createSubCategoryRequestDto));
    }

    public List<AllSubCategoriesByCategoryId> getAllSubCategoriesByCategoryId(String categoryId)
    {
        return categoryRepository.findAll().stream().filter(i -> i.getFkCategoryId() == categoryId)
                .map(subCategoryConverter::toAllSubCategoriesByCategoryIdFromEntity)
                .toList();
    }

    public void deleteSubCategoryById(String id)
    {
        categoryRepository.deleteSubCategoryById(id);
    }
}
