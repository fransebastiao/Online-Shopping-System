/*
 * ProductRepositoryTest.java
 * Test repository class for the Product
 * Author: Sharfaa Sedick Anthony 220041571
 * */

package za.ac.cput.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Product;
import za.ac.cput.factory.ProductFactory;

@TestMethodOrder(MethodOrderer.MethodName.class)

class ProductRepositoryTest {
    private static ProductRepository repository = ProductRepository.getRepository();
    private static Product product = ProductFactory.createProduct("Cement", "Used for construction of buildings.", "R1,30");

    @Test
    void a_create(){
            Product created = repository.create(product);
            assertEquals(product.getProductID(), created.getProductID());
            System.out.println("Created: " + created);
        }

    @Test
    void b_read() {
        Product read = repository.read(product.getProductID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Product updated = new Product.Builder().copy(product).setProductName("Pliers")
                .setProdDescription("Construction tool.")
                .setProdPrice("R69,99")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(product.getProductID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show All: ");
        System.out.println(repository.getAll());
    }



}