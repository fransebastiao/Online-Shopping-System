
/* Online-Shopping-System
        * Tshepang Molefe
        * 216217717
        * 10/04/2022
        */

        package za.ac.cput.factory;


import org.junit.jupiter.api.Test;
import za.ac.cput.entity.ShoppingCart;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ShoppingCartFactoryTest
{

    @Test

    void createShoppingCart()
    {
        ShoppingCart shoppingCart = ShoppingCartFactory.createShoppingCart( "2136984",  236888,  2165, "yyyy/mm/dd");
        assertNotNull(shoppingCart);
        System.out.print(shoppingCart);

    }


}