/*
 * ICategoryRepository.java
 * Repository interface for the Category
 * Author: Sharfaa Sedick Anthony 220041571
 * */

package za.ac.cput.repository;

import za.ac.cput.domain.Category;
import java.util.Set;

public interface ICategoryRepository extends IRepository<Category, String>{
    //CRUD
    public Set<Category> getAll();
}
