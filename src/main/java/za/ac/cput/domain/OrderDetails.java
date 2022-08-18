package za.ac.cput.domain;

/*
 Online-Shopping-System
 Entity for the OrderDetails
 Author: Edvalter da Costa Jamba (220446571)
 Date: 4 April 2022
 Changes Date:3 August 2022
*/

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class OrderDetails implements Serializable
{

    @EmbeddedId
    private Order orderID;

    @Embedded
    @NotNull
    private Product productID,productName;

    @NotNull
    private int quantity;

    @NotNull
    private String unitCost;

    @NotNull
    private String subTotal;

    protected OrderDetails(){  }

    //my builder constractor
    private OrderDetails(Builder builder){
        this.orderID = builder.orderID;
        this.productID = builder.productID;
        this.productName = builder.productID;
        this.quantity=builder.quantity;
        this.unitCost=builder.unitCost;
        this.subTotal=builder.subTotal;
    }


    public Order getOrderID() {
        return orderID;
    }

    public Product getProductID() {
        return productID;
    }

    public Product getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnitCost() {
        return unitCost;
    }

    public String getSubTotal() {
        return subTotal;
    }


    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderID=" + orderID +
                ", productID=" + productID +
                ", productName=" + productName +
                ", quantity=" + quantity +
                ", unitCost='" + unitCost + '\'' +
                ", subTotal='" + subTotal + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetails that = (OrderDetails) o;
        return quantity == that.quantity && Objects.equals(orderID, that.orderID) && Objects.equals(productID, that.productID) && Objects.equals(productName, that.productName) && Objects.equals(unitCost, that.unitCost) && Objects.equals(subTotal, that.subTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, productID, productName, quantity, unitCost, subTotal);
    }

    public static class Builder{

        private Order orderID;
        private Product productID,productName;
        private int quantity;
        private String unitCost;
        private String subTotal;

        public Builder setOrderID(Order orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setProductID(Product productID) {
            this.productID = productID;
            return this;
        }

        public Builder setProductName(Product productName) {
            this.productName = productName;
            return this;
        }

        public Builder setQuantity(String quantity) {
            this.quantity = Integer.parseInt(quantity);
            return this;
        }

        public Builder setUniCost(String uniCost) {
            this.unitCost = uniCost;
            return this;
        }

        public Builder setSubTotal(String subTotal) {
            this.subTotal = subTotal;
            return this;
        }

        //copy method//copy of employee object
        public Builder builder(OrderDetails orderDetails)
        {
            this.orderID = orderDetails.orderID;
            this.productID = orderDetails.productID;
            this.productName = orderDetails.productName;
            this.quantity=orderDetails.quantity;
            this.unitCost=orderDetails.unitCost;
            this.subTotal=orderDetails.subTotal;
            return this;
        }

        public OrderDetails build(){
            return new OrderDetails(this);
        }
    }

}
