package za.ac.cput.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/*
UserRole.java
This class implement builder pattern for UserRole
Siphelele Nyathi 218334028
06.08.2022
 */
@Entity
public class UserRole {

    @Id private String roleId;
    private String roleType;

    protected UserRole(){}

    public UserRole(Builder builder) {
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

        return "UserRole{" +
                "roleId='" + roleId + '\'' +
                ", roleType='" + roleType + '\'' +
                '}';
    }

    public static class Builder{
        private String roleId, roleType;

        public Builder setRoleId(String roleId) {
            this.roleId = roleId;
            return this;
        }

        public Builder setRoleType(String roleType) {
            this.roleType = roleType;
            return this;
        }

        public Builder copy(UserRole userRole){
            this.roleId = userRole.roleId;
            this.roleType = userRole.roleType;
            return this;
        }
        public UserRole build(){
            return new UserRole(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole that = (UserRole) o;
        return roleId.equals(that.roleId) &&
                roleType.equals(that.roleType);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(roleId, roleType);
    }
}
