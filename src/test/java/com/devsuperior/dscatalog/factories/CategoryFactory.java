package com.devsuperior.dscatalog.factories;

import com.devsuperior.dscatalog.entities.Category;

public class CategoryFactory {

    public static Category createCategory() {
        Category category = new Category(1L, "Electronics");
        return category;
    }


}
