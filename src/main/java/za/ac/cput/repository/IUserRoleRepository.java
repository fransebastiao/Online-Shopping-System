/*
UserRoleRepository.java
This is an interface for UserRole Repository
Siphelele Nyathi 218334028
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.UserRole;

@Repository
public interface IUserRoleRepository extends JpaRepository<UserRole, String> {

}