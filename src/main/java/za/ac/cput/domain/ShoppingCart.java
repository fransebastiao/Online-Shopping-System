package za.ac.cput.domain;
/*
 * Online-Shopping-System
 * Tshepang Molefe
 * 216217717
 * 10/04/2022
 */

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class ShoppingCart implements Serializable {
    @Id
    @NotNull
    @Column(name = "cart_id")
    private String cartId;
    @NotNull
    @Embedded
    private String productId;
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

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDateAdded() {
        return dateAdded;
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
        private String productId;
        private int quantity;
        private String dateAdded;

        public Builder setCartId(String cartId) {
            this.cartId = cartId;
            return this;
        }

        public Builder setProductId(String productId) {
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
