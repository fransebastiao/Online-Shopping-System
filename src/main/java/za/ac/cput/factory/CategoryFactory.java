/*
 * CategoryFactory.java
 * Factory class for the Category
 * Author: Sharfaa Sedick Anthony 220041571
 * //25.10.2022
 * */

package za.ac.cput.factory;

import za.ac.cput.domain.Category;
import za.ac.cput.util.GenericHelper;

public class CategoryFactory {

    public static Category createCategory(String categoryId, String categoryName, String categoryDescription){
        /*String categoryId = String.valueOf(GenericHelper.generateId());*/
        GenericHelper.checkStringParam("categoryId", categoryId);
        GenericHelper.checkStringParam("categoryName", categoryName);
        GenericHelper.checkStringParam("categoryDescription", categoryDescription);

        return new Category.Builder().setCategoryId(categoryId)
                .setCategoryName(categoryName)
                .setCategoryDescription(categoryDescription)
                .build();
    }
}