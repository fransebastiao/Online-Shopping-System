/*
 * Online-Shopping-System
 * Tshepang Molefe
 * 216217717
 * //25.10.2022
 */
package za.ac.cput.factory;

import za.ac.cput.domain.ShoppingCart;
import za.ac.cput.util.GenericHelper;

public class ShoppingCartFactory {

    public static ShoppingCart createShoppingCart(String cartId, String productId, int quantity, String dateAdded){
        GenericHelper.checkStringParam("cartId", cartId);
        GenericHelper.checkStringParam("productId", productId);
        GenericHelper.checkStringParam("dateAdded", dateAdded);

        return new ShoppingCart.Builder()
                .setCartId(cartId)
                .setProductId(productId)
                .setQuantity(quantity)
                .setDateAdded(dateAdded)
                .build();


    }
}
