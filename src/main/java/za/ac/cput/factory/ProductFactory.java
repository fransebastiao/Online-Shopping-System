/*
 * ProductFactory.java
 * Factory class for the Product
 * Author: Sharfaa Sedick Anthony 220041571
 * */

package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.util.GenericHelper;

public class ProductFactory {

    public static Product createProduct(String productName, String prodDescription, String prodPrice){
        String productId = String.valueOf(GenericHelper.generateId());

        return new Product.Builder().setProductID(productId)
                .setProductName(productName)
                .setProdDescription(prodDescription)
                .setProdPrice(prodPrice)
                .build();
    }
}