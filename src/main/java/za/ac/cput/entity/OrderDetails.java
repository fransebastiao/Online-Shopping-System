package za.ac.cput.entity;
/*
 Online-Shopping-System
 Entity for the OrderDetails
 Author: Edvalter da Costa Jamba (220446571)
 Date: 4 April 2022
*/

public class OrderDetails
{

    private String orderID;
    private String productID;
    private String productName;
    private int quantity;
    private String unitCost;
    private String subTotal;

    private OrderDetails(){}

    //my builder constractor
    public OrderDetails(Builder builder)
    {
        this.orderID = builder.orderID;
        this.productID=builder.productID;
        this.productName = builder.productName;
        this.quantity = Integer.parseInt(builder.quantity);
        this.unitCost = builder.unitCost;
        this.subTotal = builder.subTotal;

    }


    //Setter and Getter
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity( int quantity) {
        this.quantity = quantity;
    }

    public String getUniCost() {
        return unitCost;
    }

    public void setUniCost(String uniCost) {
        this.unitCost = uniCost;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }


    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderID='" + orderID + '\'' +
                ", productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity='" + quantity + '\'' +
                ", unitCost='" + unitCost + '\'' +
                ", subTotal='" + subTotal + '\'' +
                '}';
    }

    //my builder pattern Class
    public static class Builder
    {
        private String orderID;
        private String productID;
        private String productName;
        private String quantity;
        private String unitCost;
        private String subTotal;


        public Builder setOrderID(String orderID) {
            this.orderID = orderID;
            return this;
        }

        public Builder setProductID(String productID) {
            this.productID = productID;
            return this;
        }

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder setQuantity(String quantity) {
            this.quantity = quantity;
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
        public Builder copy(OrderDetails orderdetails)
        {


            this.orderID = orderdetails.orderID;
            this.productID = orderdetails.productID;
            this.productName = orderdetails.productName;
            this.quantity = String.valueOf(orderdetails.quantity);
            this.unitCost = orderdetails.unitCost;
            this.subTotal =orderdetails. subTotal;
            return this;
        }


        public OrderDetails build()
        {
            return new OrderDetails(this);
        }


    }
}
