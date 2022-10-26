/*
Region Domain
Author: Franciel Danilo de Carvalho Sebastiao
Student Number: 219466912
//25.10.2022
 */
package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Region implements Serializable {
    @NotNull
    @Id
    @Column(name = "region_id")
    private String regionId;
    @NotNull
    private int streetNumber;
    @NotNull
    private String streetName;
    @NotNull
    private int zipCode;

    private Region(Builder builder) {
        this.regionId = builder.regionId;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.zipCode = builder.zipCode;
    }

    public Region() {
    }

    public String getRegionId() {
        return regionId;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "Region{" + "regionId='" + regionId + '\'' + ", streetNumber=" + streetNumber + ", streetName='" + streetName + '\'' + ", zipCode='" + zipCode + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return streetNumber == region.streetNumber && zipCode == region.zipCode && Objects.equals(regionId, region.regionId) && Objects.equals(streetName, region.streetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionId, streetNumber, streetName, zipCode);
    }

    public static class Builder {
        private String regionId;
        private int streetNumber;
        private String streetName;
        private int zipCode;


        public Builder setRegionId(String regionId) {
            this.regionId = regionId;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setStreetNumber(int streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setZipCode(int zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder copy(Region region) {
            this.regionId = region.regionId;
            this.streetNumber = region.streetNumber;
            this.streetName = region.streetName;
            this.zipCode = region.zipCode;

            return this;
        }

        public Region build() {
            return new Region(this);
        }
    }
}
