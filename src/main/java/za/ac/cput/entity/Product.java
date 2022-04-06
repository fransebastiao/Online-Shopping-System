/*
* Product.java
* Entity for the Product
* Author: Sharfaa Sedick Anthony 220041571
* */

package za.ac.cput.entity;

public class Product {
    private int productID;
    private String productName;
    private String prodDescription;
    private float prodPrice;

    public Product() {
    }

    private Product(Builder builder) {
        this.productID = builder.productID;
        this.productName = builder.productName;
        this.prodDescription = builder.prodDescription;
        this.prodPrice = builder.prodPrice;
    }

    public int getProductID() {return productID;}

    public void setProductID(int productID) {this.productID = productID;}

    public String getProductName() {return productName;}

    public void setProductName(String productName) {this.productName = productName;}

    public String getProdDescription() {return prodDescription;}

    public void setProdDescription(String prodDescription) {this.prodDescription = prodDescription;}

    public float getProdPrice() {return prodPrice;}

    public void setProdPrice(float prodPrice) {this.prodPrice = prodPrice;}

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
        private int productID;
        private String productName;
        private String prodDescription;
        private float prodPrice;

        public Builder setProductID(int productID) {
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

        public Builder setProdPrice(float prodPrice) {
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
