/*
 * ProductFactory.java
 * Factory class for the Product
 * Author: Sharfaa Sedick Anthony 220041571
 * //25.10.2022
 * */

package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.util.GenericHelper;

public class ProductFactory {

    public static Product createProduct(String productId, String productName, String prodDescription, String prodPrice){
        GenericHelper.checkStringParam("productId",productId);
        GenericHelper.checkStringParam("productName",productName);
        GenericHelper.checkStringParam("productDescription",prodDescription);
        GenericHelper.checkStringParam("productPrice",prodPrice);

        return new Product.Builder().setProductID(productId)
                .setProductName(productName)
                .setProdDescription(prodDescription)
                .setProdPrice(prodPrice)
                .build();
    }

}