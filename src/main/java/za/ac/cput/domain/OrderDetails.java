/*
 Online-Shopping-System
 Entity for the OrderDetails
 Author: Edvalter da Costa Jamba (220446571)
 //25.10.2022
*/
package za.ac.cput.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetails implements Serializable {
    @NotNull
    private int quantity;
    @NotNull
    private String unitCost;
    @NotNull
    private String subTotal;

    private OrderDetails(Builder builder) {
        this.quantity = builder.quantity;
        this.unitCost = builder.unitCost;
        this.subTotal = builder.subTotal;
    }

    public OrderDetails() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
    }

    public String getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(String unitCost) {
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetails that = (OrderDetails) o;
        return quantity == that.quantity && Objects.equals(unitCost, that.unitCost) && Objects.equals(subTotal, that.subTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, unitCost, subTotal);
    }

    @Override
    public String toString() {
        return "OrderDetails{" + "quantity='" + quantity + '\'' + ", unitCost='" + unitCost + '\'' + ", subTotal='" + subTotal + '\'' + '}';
    }

    public static class Builder {
        private int quantity;
        private String unitCost;
        private String subTotal;

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setUnitCost(String unitCost) {
            this.unitCost = unitCost;
            return this;
        }

        public Builder setSubTotal(String subTotal) {
            this.subTotal = subTotal;
            return this;
        }

        public Builder copy(OrderDetails orderDetails) {
            this.quantity = orderDetails.quantity;
            this.unitCost = orderDetails.unitCost;
            this.subTotal = orderDetails.subTotal;

            return this;
        }

        public OrderDetails build() {
            return new OrderDetails(this);
        }
    }
}