/*
 * CategoryFactory.java
 * Factory class for the Category
 * Author: Sharfaa Sedick Anthony 220041571
 * */

package za.ac.cput.factory;

import za.ac.cput.domain.Category;
import za.ac.cput.util.GenericHelper;

public class CategoryFactory {

    public static Category createCategory(String categoryName, String categoryDescription){
        String categoryId = String.valueOf(GenericHelper.generateId());

        return new Category.Builder().setCategoryId(categoryId)
                .setCategoryName(categoryName)
                .setCategoryDescription(categoryDescription)
                .build();


    }
}