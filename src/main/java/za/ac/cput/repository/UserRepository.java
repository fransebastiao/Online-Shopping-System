package za.ac.cput.repository;
/*
UserRepository.java
This is an interface for User Repository
Siphelele Nyathi 218334028
06.08.2022
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.User;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
