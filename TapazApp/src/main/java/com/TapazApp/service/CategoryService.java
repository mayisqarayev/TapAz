package com.TapazApp.service;


import com.TapazApp.convertor.CategoryConvertor;
import com.TapazApp.dto.response.AllCategoriesResponseDto;
import com.TapazApp.dto.request.CreateCategoryRequestDto;
import com.TapazApp.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryConvertor categoryConvertor;

    public CategoryService(CategoryRepository categoryRepository, CategoryConvertor categoryConvertor) {
        this.categoryRepository = categoryRepository;
        this.categoryConvertor = categoryConvertor;
    }

    public void createCategory(CreateCategoryRequestDto createCategoryRequestDto){
        categoryRepository.save(categoryConvertor.toEntityFromCreateCategoryRequestDto(createCategoryRequestDto));
    }

    public List<AllCategoriesResponseDto> getAllCategories()
    {
        return categoryRepository.findAll().stream().map(categoryConvertor::toAllCategoriesResponseDtoFromEntity)
                .toList();
    }

    public void deleteCategoryById(String id){
        categoryRepository.deleteCategoryById(id);
    }
}