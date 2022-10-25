/*
 * Online-Shopping-System
 * Tshepang Molefe
 * 216217717
 * //25.10.2022
 */
package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Shipment implements Serializable {
    @Id
    @Column(name = "shipment_id")
    private String shipmentId;
    @NotNull
    private String contactNumber;
    @NotNull
    private int shipmentCost;
    @NotNull
    private int trackingNumber;
    @NotNull
    private String shipmentDate;
    @NotNull
    private String shipmentTime;
    @NotNull
    private String customerName;
    @NotNull
    private String deliveryAddress;


    protected Shipment() {
    }

    private Shipment(Builder builder) {
        this.shipmentId = builder.shipmentId;
        this.shipmentDate = builder.shipmentDate;
        this.customerName = builder.customerName;
        this.deliveryAddress = builder.deliveryAddress;
        this.contactNumber = builder.contactNumber;
        this.shipmentTime = builder.shipmentTime;
        this.shipmentCost = builder.shipmentCost;
        this.trackingNumber = builder.trackingNumber;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public int getShipmentCost() {
        return shipmentCost;
    }

    public int getTrackingNumber() {
        return trackingNumber;
    }

    public String getShipmentDate() {
        return shipmentDate;
    }

    public String getShipmentTime() {
        return shipmentTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    @Override
    public String toString() {
        return "Shipment{" + "shipmentId='" + shipmentId + '\'' + ", contactNumber=" + contactNumber + ", shipmentCost=" + shipmentCost + ", trackingNumber=" + trackingNumber + ", shipmentDate='" + shipmentDate + '\'' + ", shipmentTime='" + shipmentTime + '\'' + ", customerName='" + customerName + '\'' + ", deliveryAddress='" + deliveryAddress + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipment shipment = (Shipment) o;
        return shipmentCost == shipment.shipmentCost && trackingNumber == shipment.trackingNumber && Objects.equals(shipmentId, shipment.shipmentId) && Objects.equals(contactNumber, shipment.contactNumber) && Objects.equals(shipmentDate, shipment.shipmentDate) && Objects.equals(shipmentTime, shipment.shipmentTime) && Objects.equals(customerName, shipment.customerName) && Objects.equals(deliveryAddress, shipment.deliveryAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shipmentId, contactNumber, shipmentCost, trackingNumber, shipmentDate, shipmentTime, customerName, deliveryAddress);
    }

    public static class Builder {
        private String shipmentId;
        private String shipmentDate;
        private String shipmentTime;
        private String customerName;
        private String deliveryAddress;
        private String contactNumber;
        private int shipmentCost;
        private int trackingNumber;


        public Builder setShipmentId(String shipmentId) {
            this.shipmentId = shipmentId;
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

        public Builder setShipmentCost(int shipmentCost) {
            this.shipmentCost = shipmentCost;
            return this;
        }

        public Builder setTrackingNumber(int trackingNumber) {
            this.trackingNumber = trackingNumber;
            return this;
        }

        public Builder copy(Shipment shipment) {
            this.shipmentId = shipment.shipmentId;
            this.shipmentDate = shipment.shipmentDate;
            this.shipmentTime = shipment.shipmentTime;
            this.customerName = shipment.customerName;
            this.deliveryAddress = shipment.deliveryAddress;
            this.contactNumber = shipment.contactNumber;
            this.shipmentCost = shipment.shipmentCost;
            this.trackingNumber = shipment.trackingNumber;

            return this;
        }

        public Shipment build() {
            return new Shipment(this);
        }
    }

}