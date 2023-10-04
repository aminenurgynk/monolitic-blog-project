package com.aminenurgynk.controller;

import com.aminenurgynk.dto.response.CategoryResponseDto;
import com.aminenurgynk.exception.ResourceNotFoundException;
import com.aminenurgynk.repository.entity.Category;
import com.aminenurgynk.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.aminenurgynk.constant.RestApiUrl.*;

import java.util.List;

//GET http://localhost:8080/category
@RestController
@RequestMapping(CATEGORY)
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    //GET http://localhost:8080/category/getAllCategories
    @GetMapping(GETALLCATEGORIES)
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    //GET http://localhost:8080/category/getCategoryById/1
    @GetMapping(GETCATEGORY_BYID)
    public ResponseEntity<Category> getCategoryById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    //POST http://localhost:8080/category/createCategory
    @PostMapping (CREATECATEGORY)
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    //PUT http://localhost:8080/category/updateCategoryById/2
    @PutMapping(UPDATECATEGORY_BYID)
    public ResponseEntity<Category> updateCategoryById(@PathVariable(value = "id") Long id, @RequestBody Category category) throws ResourceNotFoundException{

        Category categoryInfo = getCategoryById(id).getBody();
        if (categoryInfo != null){
            categoryInfo.setId(id);
            categoryInfo.setName(category.getName());
            categoryInfo.setDescription(category.getDescription());
            return ResponseEntity.ok(categoryService.updateCategoryById(categoryInfo));
        }
        return null;
    }

    //DELETE http://localhost:8080/category/deleteCategoryById/1
    @DeleteMapping(DELETECATEGORY_BYID)
    public ResponseEntity<String> deleteCategoryById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
        return ResponseEntity.ok(categoryService.deleteCategoryById(id));
    }
}
