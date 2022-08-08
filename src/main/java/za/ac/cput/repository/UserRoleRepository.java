package za.ac.cput.repository;
/*
UserRoleRepository.java
This is an interface for UserRole Repository
Siphelele Nyathi 218334028
06.08.2022
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.UserRole;
import java.util.Set;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {
}
