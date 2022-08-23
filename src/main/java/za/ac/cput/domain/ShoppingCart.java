package za.ac.cput.domain;
/*
 * Online-Shopping-System
 * Tshepang Molefe
 * 216217717
 * 10/04/2022
 */

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ShoppingCart
            {
            @Id
            @NotNull
            private String cartId;
            @NotNull
            @Embedded
            private int productId;
            private int quantity;
            private String dateAdded;
            protected ShoppingCart()
                {}

            // private constractor
            private ShoppingCart(Builder builder) {
                this.cartId = builder.cartId;
                this.productId = builder.productId;
                this.quantity = builder.quantity;
                this.dateAdded = builder.dateAdded;


            }

            public String getCartId() {
                return cartId;
            }

            public void setCartId(String cartId) {
                this.cartId = cartId;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public String getDateAdded() {
                return dateAdded;
            }

            public void setDateAdded(String dateAdded) {
                this.dateAdded = dateAdded;
            }

            @Override
            public String toString() {
                return "ShoppingCart{" +
                        "cartId=" + cartId +
                        ", productId=" + productId +
                        ", quantity=" + quantity +
                        ", dateAdded='" + dateAdded + '\'' +
                        '}';
            }

            public static class Builder {
                private String cartId;
                private int productId;
                private int quantity;
                private String dateAdded;

                public Builder setCartId(String cartId) {
                    this.cartId = cartId;
                    return this;
                }

                public Builder setProductId(int productId) {
                    this.productId = productId;
                    return this;
                }

                public Builder setQuantity(int quantity) {
                    this.quantity = quantity;
                    return this;
                }

                public Builder setDateAdded(String dateAdded) {
                    this.dateAdded = dateAdded;
                    return this;
                }

                public Builder copy(ShoppingCart shoppingCart) {
                    this.cartId = shoppingCart.cartId;
                    this.productId = shoppingCart.productId;
                    this.quantity = shoppingCart.quantity;
                    this.dateAdded = shoppingCart.dateAdded;
                    return this;
                }

                public ShoppingCart build(){
                    return new ShoppingCart(this);
                }


            }
        }
