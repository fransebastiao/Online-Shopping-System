package za.ac.cput.service.OrderService;
/*
        Online-Shopping-System
       Services:OrderService_Interface
        Author: Edvalter da Costa Jamba (220446571)
        Date: 10 August 2022
*/

import za.ac.cput.domain.Order;
import za.ac.cput.service.IService;

public interface OrderService extends IService<Order, String> {
    void deleteById(String id);
}
