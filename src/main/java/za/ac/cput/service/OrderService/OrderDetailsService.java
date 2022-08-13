package za.ac.cput.service.OrderService;
/*
 Online-Shopping-System
 Services:OrderDetails Interface
 Author: Edvalter da Costa Jamba (220446571)
 Date: 10 August 2022
*/

import za.ac.cput.domain.OrderDetails;
import za.ac.cput.service.IService;


public interface OrderDetailsService extends IService<OrderDetails, String> {
    void deleteById(String id);
}
