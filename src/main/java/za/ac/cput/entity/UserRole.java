package za.ac.cput.entity;
/*
User.java
This class implement builder pattern for UserRole
Siphelele Nyathi 218334028
O4.04.2022
 */

public class UserRole {

    private String roleId, roleType;

    public UserRole(Builder builder) {
        this.roleId = builder.roleId;
        this.roleType = builder.roleType;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
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

        public UserRole build(){
            return new UserRole(this);
        }
    }
}
