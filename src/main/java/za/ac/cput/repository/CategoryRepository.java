/*
 * CategoryRepository.java
 * Repository class for the Category
 * Author: Sharfaa Sedick Anthony 220041571
 * */

package za.ac.cput.repository;

import za.ac.cput.entity.Category;
import java.util.HashSet;
import java.util.Set;

public class CategoryRepository implements ICategoryRepository {

    public static CategoryRepository repository = null;
    private Set<Category> categoryDB = null;

    private CategoryRepository(){
        categoryDB = new HashSet<Category>();
    }

    public static CategoryRepository getRepository(){
        if(repository == null){
            repository = new CategoryRepository();
        }
        return repository;
    }

    @Override
    public Category create(Category category) {
        boolean success = categoryDB.add(category);
        if (!success) return null;
        return category;
    }

    @Override
    public Category read(String categoryID) {
        for(Category e: categoryDB)
            if(e.getCategoryId().equals(categoryID))
                return e;
        return null;
    }

    @Override
    public Category update(Category category) {
        Category oldCategory = read(category.getCategoryId());
        if (oldCategory != null) {
            categoryDB.remove(oldCategory);
            categoryDB.add(category);
            return category;
        }
        return null;
    }

    @Override
    public boolean delete(String categoryID) {
        Category categoryToDelete = read(categoryID);
        if (categoryToDelete == null) {
            return false;
        }
        categoryDB.remove(categoryToDelete);

        return true;
    }

    @Override
    public Set<Category> getAll() {
        return categoryDB;
    }

}
