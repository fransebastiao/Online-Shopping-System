package za.ac.cput.entity;

import java.time.LocalDateTime;

public class Region {
    private String regionId;
    private int streetNumber;
    private String streetName;
    private int zipCode;

    private Region(){}

    private Region (Region.Builder builder){
        this.regionId = builder.regionId;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.zipCode = builder.zipCode;
    }

    public String getRegionId() {
        return regionId;
    }

    public int getStreetNumber() { return streetNumber; }

    public String getStreetName() {
        return streetName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Region{" +
                "regionId=" + regionId +
                ", streetNumber=" + streetNumber +
                ", streetName='" + streetName + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }

    public static class Builder{
        private String regionId;
        private int streetNumber;
        private String streetName;
        private int zipCode;

        public Builder setRegionId(String regionId) {
            this.regionId = regionId;
            return this;
        }

        public Builder setStreetNumber(int streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setZipCode(int zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Region.Builder copy(Region region){
            this.regionId = region.regionId;
            this.streetNumber = region.streetNumber;
            this.streetName = region.streetName;
            this.zipCode = region.zipCode;
            return this;
        }

        public Region build(){
            return new Region(this);
        }
    }
}
