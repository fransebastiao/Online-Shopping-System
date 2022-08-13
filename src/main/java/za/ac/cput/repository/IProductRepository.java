/*
 * IProductRepository.java
 * Repository interface for the Product
 * Author: Sharfaa Sedick Anthony 220041571
 * */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, String> {

}
