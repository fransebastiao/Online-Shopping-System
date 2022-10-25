package za.ac.cput.domain;

/*
 Online-Shopping-System
 Entity for the Order
 Author: Edvalter da Costa Jamba (220446571)
 //25.10.2022
*/

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="Orders")
public class Order implements Serializable {
    @Id
    @Column(name = "orderered_id")
    private String orderId;
    @NotNull
    private String orderDate;
    @NotNull
    private String orderStatus;
    @NotNull
    private String customerName;
    @NotNull
    private String deliveryAddress;
    @NotNull
    private int contactNumber;
    @Embedded
    @NotNull
    private OrderDetails details;

    public Order() {
    }

    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.orderDate = builder.orderDate;
        this.orderStatus = builder.orderStatus;
        this.customerName = builder.customerName;
        this.deliveryAddress = builder.deliveryAddress;
        this.contactNumber = builder.contactNumber;
        this.details = builder.details;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public OrderDetails getDetails() {
        return details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return contactNumber == order.contactNumber && Objects.equals(orderId, order.orderId) && Objects.equals(orderDate, order.orderDate) && Objects.equals(orderStatus, order.orderStatus) && Objects.equals(customerName, order.customerName) && Objects.equals(deliveryAddress, order.deliveryAddress) && Objects.equals(details, order.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderDate, orderStatus, customerName, deliveryAddress, contactNumber, details);
    }

    @Override
    public String toString() {
        return "Order{" + "orderId='" + orderId + '\'' + ", orderDate='" + orderDate + '\'' + ", orderStatus='" + orderStatus + '\'' + ", customerName='" + customerName + '\'' + ", deliveryAddress='" + deliveryAddress + '\'' + ", contactNumber=" + contactNumber + ", details=" + details + '}';
    }

    public static class Builder {
        private String orderId;
        private String orderDate;
        private String orderStatus;
        private String customerName;
        private String deliveryAddress;
        private int contactNumber;
        private OrderDetails details;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setOrderDate(String orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        public Builder setContactNumber(int contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder setDetails(OrderDetails details) {
            this.details = details;
            return this;
        }


        public Builder copy(Order order) {
            this.orderId = order.orderId;
            this.orderDate = order.orderDate;
            this.orderStatus = order.orderStatus;
            this.customerName = order.customerName;
            this.deliveryAddress = order.deliveryAddress;
            this.contactNumber = order.contactNumber;
            this.details = order.details;

            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}