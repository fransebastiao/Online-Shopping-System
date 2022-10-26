/*
UserRepository.java
This is an interface for User Repository
Siphelele Nyathi 218334028
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.User;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {

}