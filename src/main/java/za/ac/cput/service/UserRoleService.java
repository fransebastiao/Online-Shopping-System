package za.ac.cput.service;
/*
UserService.java
This is an interface for User Role Services
Siphelele Nyathi 218334028
14.08.2022
 */

import za.ac.cput.domain.UserRole;

public interface UserRoleService extends IService<UserRole, String>
{
    boolean delete(String id);
}

