package com.process.shop.service.Category;

// CategoryService.java
import com.process.shop.model.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);

    Category getCategoryById(Long id);

    List<Category> getAllCategories();

    Category updateCategory(Category category, Long id);
}
