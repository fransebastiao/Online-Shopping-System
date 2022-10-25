/*
 * shoppingCart Test
 * Online-shopping-System
 * 216217717
 * //25.10.2022
 * */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.ShoppingCart;
import za.ac.cput.factory.ShoppingCartFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class ShoppingCartServiceImplTest {
    private static final ShoppingCart shoppingCart1 = ShoppingCartFactory.createShoppingCart("01", "SN458",2,"20/12/2021");
    private static final ShoppingCart shoppingCart2 = ShoppingCartFactory.createShoppingCart("08", "SN467",9,"20/11/2021");

    @Autowired
    private ShoppingCartServiceImpl service;

    @Test
    void a_save() {
        System.out.println("Created: ");
        ShoppingCart created1 = service.save(shoppingCart1);
        assertNotNull(created1);
        System.out.println(created1);

        ShoppingCart created2 = service.save(shoppingCart2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    void b_read() {
        ShoppingCart read = service.read(shoppingCart1.getCartId());
        assertEquals(read.getCartId(), shoppingCart1.getCartId());
        System.out.println("Show Cart: " + read);
    }

    @Test
    void f_delete() {
        boolean success = service.delete(shoppingCart1.getCartId());
        assertTrue(success);
        System.out.println("Deleted Cart: " + success);
    }

    @Test
    void d_findAll() {
        System.out.println("Show all:");
        System.out.println(service.findAll());
    }
}