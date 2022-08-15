package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class OrderDetailsServiceImplTest {


    private static final Product product = ProductFactory.createProduct("Chipps", "Ch", "R20");

    @Autowired
    private ProductServiceImpl service;


    @Test
    void a_save()
    {
        System.out.println("Product Created: ");
        Product prod = service.save(product);
        assertNotNull(prod);
        System.out.println(prod);
    }

    @Test
    void b_read()
    {
        Product read = service.read(product.getProductID());
        assertEquals(read.getProductID(), product.getProductID());
        System.out.println("Reading Products: " + read);
    }

    @Test
    void c_delete() {
        boolean success = service.delete(product.getProductID());
        assertTrue(success);
        System.out.println("Product Deleted: " + success);
    }

    @Test
    void d_findAll()
    {
        System.out.println("Get All");
        System.out.println(service.findAll());
    }



}