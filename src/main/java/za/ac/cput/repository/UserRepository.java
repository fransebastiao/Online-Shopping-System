package za.ac.cput.repository;
/*
UserRepository.java
User Repository
Author: Siphelele Nyathi 218334028
Date: O4.04.2022
 */
import za.ac.cput.domain.User;
import java.util.Set;


public interface UserRepository extends IRepository<User, String>{

     Set<User> getAll();
}
