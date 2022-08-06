/*
 * CategoryFactoryTest.java
 * Factory Test class for the Category
 * Author: Sharfaa Sedick Anthony 220041571
 * */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Category;

import static org.junit.jupiter.api.Assertions.*;

class CategoryFactoryTest {

    @Test
    void createCategory(){
        Category category = CategoryFactory.createCategory("Construction", "Items used for construction.");
        assertNotNull(category);
        System.out.println(category);
    }
}