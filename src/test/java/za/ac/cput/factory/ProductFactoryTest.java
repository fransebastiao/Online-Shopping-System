/*
 * ProductFactoryTest.java
 * Factory Test class for the Product
 * Author: Sharfaa Sedick Anthony 220041571
 * */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Product;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProductFactoryTest {

    @Test
    void createProduct(){
        Product product = ProductFactory.createProduct("Bricks", "Used for construction of homes.", "R4.20");
        assertNotNull(product);
        System.out.println(product);


    }
}