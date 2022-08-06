package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.OrderDetails;

@Repository
public interface OrderDetailsRpository extends JpaRepository<OrderDetails, String> {
}
