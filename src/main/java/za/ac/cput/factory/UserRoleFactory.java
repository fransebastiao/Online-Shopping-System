/*
UserRoleFactory.java
Factory class for UserRole
Author: Siphelele Nyathi 218334028
//25.10.2022
 */
package za.ac.cput.factory;

import za.ac.cput.domain.UserRole;
import za.ac.cput.util.GenericHelper;

public class UserRoleFactory {
    public static UserRole createUserRole(String roleId, String roleType){
        GenericHelper.checkStringParam("roleId", roleId);
        GenericHelper.checkStringParam("roleType", roleType);

        return new UserRole.Builder()
                .setRoleId(roleId)
                .setRoleType(roleType)
                .build();
    }
}