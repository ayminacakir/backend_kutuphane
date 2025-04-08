
package com.example.backend_kutuphane.services;

import com.example.backend_kutuphane.entities.Categories;
import com.example.backend_kutuphane.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {

    private final CategoriesRepository categoryRepository;

    @Autowired
    public CategoriesService(CategoriesRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Categories> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Categories> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }


    public Categories createCategory(Categories category) {
        return categoryRepository.save(category);
    }


    public Categories updateCategory(Long id, Categories categoryDetails) {
        Optional<Categories> category = categoryRepository.findById(id);

        if (category.isPresent()) {
            Categories existingCategory = category.get();
            existingCategory.setName(categoryDetails.getName());

            return categoryRepository.save(existingCategory);
        } else {

            return null;
        }
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
