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

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartServiseImplTest
{

    ShoppingCart shoppingCart = ShoppingCartFactory.createShoppingCart("25008", 258,369,"12/8/2022");

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

        ShoppingCart optionalCart = shoppingCartServiseImpl.read(shoppingCart.getCartId());

        assertEquals(shoppingCart.getCartId(), optionalCart.getCartId());

        System.out.println("Show Cart: " + optionalCart);
    }
    @Order(4)
    @Test
    void delete()
    {

        boolean isDeleted = shoppingCartServiseImpl.delete(shoppingCart.getCartId());
        Set<ShoppingCart> cartSet = shoppingCartServiseImpl.findAll();

        assertEquals(0, cartSet.size());
        System.out.println("Deleted Cart: " + isDeleted);
    }
    @Order(3)
    @Test
    void findAll()
    {
        Set<ShoppingCart> shoppingCartList = this.shoppingCartServiseImpl.findAll();
        assertEquals(1, shoppingCartList.size());
        System.out.println(shoppingCartList);
    }
}