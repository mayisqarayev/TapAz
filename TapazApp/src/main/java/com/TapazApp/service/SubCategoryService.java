package com.TapazApp.service;

import com.TapazApp.converter.SubCategoryConverter;
import com.TapazApp.dto.request.CreateSubCategoryRequestDto;
import com.TapazApp.dto.response.AllSubCategoriesResponseDto;
import com.TapazApp.entity.SubCategoryEntity;
import com.TapazApp.repository.SubCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService {

    private final SubCategoryRepository categoryRepository;
    private final SubCategoryConverter subCategoryConverter;
    private final CategoryService categoryService;

    public SubCategoryService(SubCategoryRepository categoryRepository, SubCategoryConverter subCategoryConverter, CategoryService categoryService) {
        this.categoryRepository = categoryRepository;
        this.subCategoryConverter = subCategoryConverter;
        this.categoryService = categoryService;
    }

    public void createSubCategory(CreateSubCategoryRequestDto createSubCategoryRequestDto)
    {
        categoryRepository.save(subCategoryConverter.toEntityFromCreateSubCategoryRequestDto(createSubCategoryRequestDto));
    }

    public List<AllSubCategoriesResponseDto> getAllSubCategoriesByCategoryId(String categoryId)
    {
        return categoryRepository.findAll().stream()
                .filter(i -> i.getFkCategoryId() == categoryId)
                .map(subCategoryConverter::toAllSubCategoriesByCategoryIdFromEntity)
                .toList();
    }

    public void deleteSubCategoryById(String id)
    {
        categoryRepository.deleteSubCategoryById(id);
    }

    public AllSubCategoriesResponseDto getSubCategoryById(String id)
    {
        SubCategoryEntity entity = categoryRepository.findById(id).get();

        return new AllSubCategoriesResponseDto(
                entity.getSubCategoryName(),
                categoryService.getCategoryById(entity.getFkCategoryId())
        );
    }

}
