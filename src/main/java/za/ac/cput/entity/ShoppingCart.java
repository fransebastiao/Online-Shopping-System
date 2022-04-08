package za.ac.cput.entity;
/*
 * Online-Shopping-System
 * Tshepang Molefe
 * 216217717
 * 10/04/2022
 */

public class ShoppingCart
            {
            private String cartId;
            private int productId;
            private int quantity;
            private String dateAdded;

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

                public ShoppingCart builder(){
                    return new ShoppingCart(this);
                }


            }
        }
