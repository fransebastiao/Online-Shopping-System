/*
UserRole.java
This class implement builder pattern for UserRole
Siphelele Nyathi 218334028
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
public class UserRole implements Serializable {
    @Id
    @Column(name = "role_id")
    private String roleId;

    @NotNull
    private String roleType;

    protected UserRole() {
    }

    private UserRole(Builder builder) {
        this.roleId = builder.roleId;
        this.roleType = builder.roleType;

    }

    public String getRoleId() {
        return roleId;
    }

    public String getRoleType() {
        return roleType;
    }

    @Override
    public String toString() {
        return "UserRole{" + "roleId='" + roleId + '\'' + ", roleType='" + roleType + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return Objects.equals(roleId, userRole.roleId) && Objects.equals(roleType, userRole.roleType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleType);
    }

    public static class Builder {
        private String roleId;
        private String roleType;


        public Builder setRoleId(String roleId) {
            this.roleId = roleId;
            return this;
        }

        public Builder setRoleType(String roleType) {
            this.roleType = roleType;
            return this;
        }


        public Builder copy(UserRole userRole) {
            this.roleId = userRole.roleId;
            this.roleType = userRole.roleType;
            return this;
        }

        public UserRole build() {
            return new UserRole(this);
        }
    }

}
