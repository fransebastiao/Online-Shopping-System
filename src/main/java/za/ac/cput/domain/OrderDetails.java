package za.ac.cput.domain;

/*
 Online-Shopping-System
 Entity for the OrderDetails
 Author: Edvalter da Costa Jamba (220446571)
 Date: 4 April 2022
 Changes Date:3 August 2022
*/

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetails implements Serializable
{
    @NotNull private int quantity;
    @NotNull private String unitCost;
    @NotNull private String subTotal;

    protected OrderDetails(){  }

    //my builder constractor
    private OrderDetails(Builder builder){
        this.quantity=builder.quantity;
        this.unitCost=builder.unitCost;
        this.subTotal=builder.subTotal;
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
                ", quantity=" + quantity +
                ", unitCost='" + unitCost + '\'' +
                ", subTotal='" + subTotal + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetails)) return false;
        OrderDetails that = (OrderDetails) o;
        return quantity == that.quantity && Objects.equals(unitCost, that.unitCost) && Objects.equals(subTotal, that.subTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, unitCost, subTotal);
    }

    public static class Builder{

        private int quantity;
        private String unitCost;
        private String subTotal;

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
