/*
 * ProductRepository.java
 * Repository class for the Product
 * Author: Sharfaa Sedick Anthony 220041571
 * */

package za.ac.cput.repository;

import za.ac.cput.domain.Product;
import java.util.HashSet;
import java.util.Set;

public class ProductRepository implements IProductRepository {
    public static ProductRepository repository = null;
    private Set<Product> productDB = null;

    private ProductRepository(){
        productDB = new HashSet<Product>();
    }

    public static ProductRepository getRepository(){
        if(repository == null){
            repository = new ProductRepository();
        }
        return repository;
    }

    @Override
    public Product create(Product product) {
        boolean success = productDB.add(product);
        if (!success) return null;
        return product;
    }

    @Override
    public Product read(String productID) {
        for(Product e: productDB)
        if(e.getProductID().equals(productID))
            return e;
        return null;
    }

    @Override
    public Product update(Product product) {
        Product oldProduct = read(product.getProductID());
        if (oldProduct != null) {
            productDB.remove(oldProduct);
            productDB.add(product);
            return product;
        }
        return null;
    }

    @Override
    public boolean delete(String productID) {
        Product productToDelete = read(productID);
        if (productToDelete == null) {
            return false;
        }
        productDB.remove(productToDelete);

        return true;
    }

    @Override
    public Set<Product> getAll() {
        return productDB;
    }

}
