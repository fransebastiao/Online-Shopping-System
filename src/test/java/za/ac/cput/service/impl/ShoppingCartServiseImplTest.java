/*
 * shoppingCart Test
 *  Online-shopping-System
 * 216217717
 * 12-08-2022
 * */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.ShoppingCart;
import za.ac.cput.factory.ShoppingCartFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShoppingCartServiseImplTest {
    private static final ShoppingCart shoppingCart1 = ShoppingCartFactory.createShoppingCart("01", "SN458",2,"20/12/2021");

    @Autowired
    private ShoppingCartServiseImpl shoppingCartServiceImpl;

    @Test
    void a_save() {
        ShoppingCart saved = this.shoppingCartServiceImpl.save(this.shoppingCart1);
        assertNotNull(saved);
        System.out.println(saved);
    }

    @Test
    void b_read() {
        ShoppingCart read = shoppingCartServiceImpl.read(shoppingCart1.getCartId());
        assertEquals(read.getCartId(), shoppingCart1.getCartId());
        System.out.println("Show Cart: " + read);
    }

    @Test
    void d_delete() {
        boolean isDeleted = shoppingCartServiceImpl.delete(shoppingCart1.getCartId());
        assertTrue(isDeleted);
        System.out.println("Deleted Cart: " + isDeleted);
    }

    @Test
    void c_findAll() {
        System.out.println("Show all:");
        System.out.println(shoppingCartServiceImpl.findAll());
    }
}