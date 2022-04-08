package za.ac.cput.entity;
/*
* Online-Shopping-System
* Tshepang Molefe
* 216217717
* 10/04/2022
 */

public class Shipment
{

    private String shipmentId;
    private int shipmentCost;
    private String customerName;
    private String deliveryAddress;
    private int contactNumber;
    private int trackingNumber;
    private String shipmentDate;
    private String shipmentTime;

    // private constractor

    private Shipment(Builder builder) {
        this.shipmentId = builder.shipmentId;
        this.shipmentCost = builder.shipmentCost;
        this.customerName = builder.customerName;
        this.deliveryAddress = builder.deliveryAddress;
        this.contactNumber = builder.contactNumber;
        this.trackingNumber = builder.trackingNumber;
        this.shipmentDate = builder.shipmentDate;
        this.shipmentTime = builder.shipmentTime;
    }


    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public int getShipmentCost() {
        return shipmentCost;
    }

    public void setShipmentCost(int shipmentCost) {
        this.shipmentCost = shipmentCost;
    }

    public String getcustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName=customerName;
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

    public int getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(int trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(String shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public String getShipmentTime() {
        return shipmentTime;
    }

    public void setShipmentTime(String shipmentTime) {
        this.shipmentTime = shipmentTime;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "shipmentId=" + shipmentId +
                ", shipmentCost=" + shipmentCost +
                ", customerName='" + customerName + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", contactNumber=" + contactNumber +
                ", trackingNumber=" + trackingNumber +
                ", shipmentDate='" + shipmentDate + '\'' +
                ", shipmentTime='" + shipmentTime + '\'' +
                '}';
    }

    public static class Builder
    {
        public String customerName;
        private String shipmentId;
        private int shipmentCost;
        private String deliveryAddress;
        private int contactNumber;
        private int trackingNumber;
        private String shipmentDate;
        private String shipmentTime;


        public Builder setShipmentId(String shipmentId) {
            this.shipmentId = shipmentId;
            return this;
        }

        public Builder setShipmentCost(int shipmentCost) {
            this.shipmentCost = shipmentCost;
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

        public Builder setTrackingNumber(int trackingNumber) {
            this.trackingNumber = trackingNumber;
            return this;
        }

        public Builder setShipmentDate(String shipmentDate) {
            this.shipmentDate = shipmentDate;
            return this;
        }

        public Builder setShipmentTime(String shipmentTime) {
            this.shipmentTime = shipmentTime;
            return this;
        }

        public Builder copy(Shipment shipment) {
            this.shipmentId = shipment.shipmentId;
            this.shipmentCost = shipment.shipmentCost;
            this.customerName = shipment.customerName;
            this.deliveryAddress = shipment.deliveryAddress;
            this.contactNumber = shipment.contactNumber;
            this.trackingNumber = shipment.trackingNumber;
            this.shipmentDate = shipment.shipmentDate;
            this.shipmentTime = shipment.shipmentTime;

            return this;
        }

        public Shipment builder()
        {
            return new Shipment(this);
        }

    }
}
