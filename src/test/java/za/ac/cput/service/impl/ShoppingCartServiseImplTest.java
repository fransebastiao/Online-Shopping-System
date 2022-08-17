/*
* shoppingCart Test
*  Online-shopping-System
* 216217717
* 12-08-2022
* */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Shipment;
import za.ac.cput.domain.ShoppingCart;
import za.ac.cput.factory.ShipmentFactory;
import za.ac.cput.factory.ShoppingCartFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartServiseImplTest
{
    @Autowired
    private  ShoppingCart shoppingCart ;

    @Autowired
    private ShoppingCartServiseImpl shoppingCartServiseImpl;

    @Order(1)
    @Test
    void save()
    {
        ShoppingCart saved = this.shoppingCartServiseImpl.save(this.shoppingCart);
        assertEquals(this.shoppingCart, saved);
        System.out.println(saved);
    }
    @Order(2)
    @Test
    void read()
    {
        Optional<ShoppingCart> read = this.shoppingCartServiseImpl.read(this.shoppingCart.getCartId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.shoppingCart, read.get()));
    }
    @Order(4)
    @Test
    void delete()
    {
        this.shoppingCartServiseImpl.deleteById(this.shoppingCart.getCartId());
        List<ShoppingCart> shoppingCartList = this.shoppingCartServiseImpl.findAll();
        assertEquals(0, shoppingCartList.size());
    }
    @Order(3)
    @Test
    void findAll()
    {
        List<ShoppingCart> shoppingCartList = this.shoppingCartServiseImpl.findAll();
        assertEquals(1, shoppingCartList.size());
        System.out.println(shoppingCartList);
    }
}