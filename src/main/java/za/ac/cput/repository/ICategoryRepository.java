/*
 * ICategoryRepository.java
 * Repository interface for the Category
 * Author: Sharfaa Sedick Anthony 220041571
 * */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, String> {
}
