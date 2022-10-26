package za.ac.cput.repository;
/*
Account Repository
Author: Franciel Danilo de Carvalho Sebastiao
Student Number: 219466912
Date: O6/08/2022
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, String> {

}
