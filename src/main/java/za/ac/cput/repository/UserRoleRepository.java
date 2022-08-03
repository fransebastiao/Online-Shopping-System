package za.ac.cput.repository;
/*
UserRoleRepository.java
User Role Repository
Author: Siphelele Nyathi 218334028
Date: O4.04.2022
 */
import za.ac.cput.domain.UserRole;
import java.util.Set;

public interface UserRoleRepository extends IRepository<UserRole, String> {

    Set<UserRole> getAll();
}
