package za.ac.cput.domain;
/*
Region Domain
Author: Franciel Danilo de Carvalho Sebastiao
Student Number: 219466912
Date: O6/08/2022
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Region {
    @Id String regionId;
    @NotNull int streetNumber;
    @NotNull String streetName;
    @NotNull int zipCode;

    protected Region(){}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return streetNumber == region.streetNumber && zipCode == region.zipCode &&
                Objects.equals(regionId, region.regionId) && Objects.equals(streetName, region.streetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionId, streetNumber, streetName, zipCode);
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
}
