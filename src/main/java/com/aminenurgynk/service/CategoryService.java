package com.aminenurgynk.service;

import com.aminenurgynk.dto.response.CategoryResponseDto;
import com.aminenurgynk.exception.ResourceNotFoundException;
import com.aminenurgynk.mapper.ICategoryMapper;
import com.aminenurgynk.repository.ICategoryRepository;
import com.aminenurgynk.repository.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    ICategoryRepository categoryRepository;

    public List<CategoryResponseDto> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        if (categoryList.isEmpty()){
            throw new RuntimeException("No data was found");
        }
        return ICategoryMapper.INSTANCE.toCategoryResponseDtos(categoryList);
    }

    public Category getCategoryById(Long id) throws ResourceNotFoundException {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category could not found!!"));
        return categoryRepository.findById(id).get();
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategoryById(Category categoryInfo) throws ResourceNotFoundException {
        Category category = categoryRepository.findById(categoryInfo.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Category could not found!!"));
        return categoryRepository.save(categoryInfo);
    }

    public String deleteCategoryById(Long id) throws ResourceNotFoundException {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category could not found!!"));
        categoryRepository.deleteById(id);
        return "The category has been deleted from the database";
    }
}
