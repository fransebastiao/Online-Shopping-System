/*
 * CategoryRepositoryTest.java
 * Test repository class for the Category
 * Author: Sharfaa Sedick Anthony 220041571
 * */

package za.ac.cput.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Category;
import za.ac.cput.factory.CategoryFactory;

@TestMethodOrder(MethodOrderer.MethodName.class)

class CategoryRepositoryTest {
    private static CategoryRepository repository = CategoryRepository.getRepository();
    private static Category category = CategoryFactory.createCategory("Tools", "Tools used for construction");

    @Test
    void a_create(){
        Category created = repository.create(category);
        assertEquals(category.getCategoryId(), created.getCategoryId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Category read = repository.read(category.getCategoryId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Category updated = new Category.Builder().copy(category).setCategoryName("Gear")
                .setCategoryDescription("Work attire for employees.")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(category.getCategoryId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show All: ");
        System.out.println(repository.getAll());
    }



}