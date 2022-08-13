package za.ac.cput.service.OrderService;
/*
        Online-Shopping-System
        Services:OrderDetailsImpl
        Author: Edvalter da Costa Jamba (220446571)
        Date: 10 August 2022
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.OrderDetails;
import za.ac.cput.repository.OrderDetailsRpository;
import java.util.List;
import java.util.Optional;


@Service
public class OrderDetailsServiceImpl implements OrderDetailsService
{
    private final OrderDetailsRpository repository;

    @Autowired
    public OrderDetailsServiceImpl(OrderDetailsRpository repository)
    {
        this.repository = repository;
    }

    @Override
    public OrderDetails save(OrderDetails orderDetails) {
        return this.repository.save(orderDetails);
    }

    @Override
    public Optional<OrderDetails> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(OrderDetails orderDetails) {
        this.repository.delete(orderDetails);
    }

    @Override
    public List<OrderDetails> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id)
    {

        repository.deleteById(id);
        Optional<OrderDetails> orderDetails = read(id);
        if (orderDetails.isPresent()) {
            delete(orderDetails.get());
        }

    }
}
