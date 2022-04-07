package za.ac.cput.entity;
/*
 Online-Shopping-System
 Entity for the Order
 Author: Edvalter da Costa Jamba (220446571)
 Date: 4 April 2022
*/

public class Order
{

    private String orderID;
    private String orderDate;
    private String orderStatus;
    private String customerName;
    private String deliveryAddress;
    private int contactNumber;

    private Order(){}

    //my builder constractor
    public Order(Builder builder)
    {
        this.orderID = builder.orderID;
        this.orderDate = builder.orderDate;
        this.orderStatus = builder.orderStatus;
        this.customerName = builder.customerName;
        this.deliveryAddress = builder.deliveryAddress;
        this.contactNumber = Integer.parseInt(builder. contactNumber);
    }


    //Setter and Getters
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", customerName='" + customerName + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
    //my builder pattern Class
    public static class Builder
    {
        private String orderID;
        private String orderDate;
        private String orderStatus;
        private String customerName;
        private String deliveryAddress;
        private String contactNumber;

        public Builder setOrderID(String orderID) {
            this.orderID = orderID;
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

        public Builder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }



        //copy method//copy of employee object
        public Builder copy(Order order)
        {
            this.orderID = order.orderID;
            this.orderDate = order.orderDate;
            this.orderStatus = order.orderStatus;
            this.customerName = order.customerName;
            this.deliveryAddress = order.deliveryAddress;
            this.contactNumber = String.valueOf(order. contactNumber);
            return this;
        }


        public Order build()
        {
            return new Order(this);
        }



    }

}
