package za.ac.cput.repository;
/*
 Online-Shopping-System
 Entity for the OrderDetailsRepository
 Author: Edvalter da Costa Jamba (220446571)
 Date: 4 April 2022
 Changes Date:3 August 2022
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.OrderDetails;

@Repository
public interface OrderDetailsRpository extends JpaRepository<OrderDetails, String> {
}
