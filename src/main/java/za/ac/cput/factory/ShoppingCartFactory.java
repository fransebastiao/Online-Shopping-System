
/*
 * Online-Shopping-System
 * Tshepang Molefe
 * 216217717
 * 10/04/2022
 */
package za.ac.cput.factory;

import za.ac.cput.domain.ShoppingCart;
import za.ac.cput.util.GenericHelper;


public class ShoppingCartFactory
{

    // create all account object
    public static ShoppingCart createShoppingCart (String cartId,int productId, int quantity, String dateAdded){


        if (GenericHelper.isNullorEmpty(cartId))
            return null;


        return new ShoppingCart.Builder().setCartId(cartId).setProductId(productId)
                .setQuantity(quantity).setDateAdded(dateAdded)
                .build();
    }

    public static ShoppingCart build(String cartId, int productId, int quantity, String dateAdded)
    {
        return new ShoppingCart.Builder().setCartId(cartId).setProductId(productId)
                .setQuantity(quantity).setDateAdded(dateAdded)
                .build();
    }
}