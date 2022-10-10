/*
 * Online-Shopping-System
 * Tshepang Molefe
 * 216217717
 * 08/Augast/2022
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.ShoppingCart;


@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, String> {
}