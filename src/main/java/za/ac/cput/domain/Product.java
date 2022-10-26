/*
 * Product.java
 * Entity for the Product
 * Author: Sharfaa Sedick Anthony 220041571
 * //25.10.2022
 * */

package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Product implements Serializable {
    @NotNull
    @Id
    @Column(name = "product_id")
    private String productID;
    @NotNull
    @Column(name = "product_name")
    private String productName;
    @NotNull
    private String prodDescription;
    @NotNull
    private String prodPrice;

    public Product() {
    }

    private Product(Builder builder) {
        this.productID = builder.productID;
        this.productName = builder.productName;
        this.prodDescription = builder.prodDescription;
        this.prodPrice = builder.prodPrice;
    }

    public String getProductID() {return productID;}
    public String getProductName() {return productName;}
    public String getProdDescription() {return prodDescription;}
    public String getProdPrice() {return prodPrice;}

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", prodDescription='" + prodDescription + '\'' +
                ", prodPrice=" + prodPrice +
                '}';
    }

    public static class Builder {
        private String productID;
        private String productName;
        private String prodDescription;
        private String prodPrice;

        public Builder setProductID(String productID) {
            this.productID = productID;
            return this;
        }

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder setProdDescription(String prodDescription) {
            this.prodDescription = prodDescription;
            return this;
        }

        public Builder setProdPrice(String prodPrice) {
            this.prodPrice = prodPrice;
            return this;
        }

        public Builder copy(Product prod) {
            this.productID = prod.productID;
            this.productName = prod.productName;
            this.prodDescription = prod.prodDescription;
            this.prodPrice = prod.prodPrice;
            return this;
        }

        public Product build() {return new Product(this);
        }
    }
}
