/*
 * ProductServiceImplTest.java
 * Service Implementation Test class for Product
 * Author: Sharfaa Sedick Anthony 220041571
 * //25.10.2022
 * */

package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Shipment;
import za.ac.cput.factory.ProductFactory;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class ProductServiceImplTest {
    private static final Product product1 = ProductFactory.createProduct("65748352","Tissues", "1", "R30");
    private static final Product product2 = ProductFactory.createProduct("14356289","Box", "3", "R15");
    private static final Product product3 = ProductFactory.createProduct("67802436","Heater", "12", "R699");

    @Autowired
    private ProductServiceImpl service;

    @Test
    void a_save() {
        System.out.println("Created: ");
        Product created1 = service.save(product1);
        assertNotNull(created1);
        System.out.println(created1);

        Product created2 = service.save(product2);
        assertNotNull(created2);
        System.out.println(created2);

        Product created3 = service.save(product3);
        assertNotNull(created3);
        System.out.println(created3);
    }

    @Test
    void b_read() {
        Product read = service.read(product1.getProductID());
        assertEquals(product1.getProductID(), read.getProductID());
        System.out.println("Show Shipments: " + read);
    }

    @Test
    void f_delete() {
        boolean success = service.delete(product3.getProductID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getALl() {
        System.out.println("Get All");
        System.out.println(service.findAll());
    }

}