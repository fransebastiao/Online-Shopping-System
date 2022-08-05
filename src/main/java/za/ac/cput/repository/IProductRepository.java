/*
 * IProductRepository.java
 * Repository interface for the Product
 * Author: Sharfaa Sedick Anthony 220041571
 * */

package za.ac.cput.repository;

import za.ac.cput.domain.Product;
import java.util.Set;

public interface IProductRepository extends IRepository<Product, String>{
    // CRUD
    public Set<Product> getAll();
}
