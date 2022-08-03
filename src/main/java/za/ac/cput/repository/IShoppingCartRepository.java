package za.ac.cput.repository;
import za.ac.cput.domain.ShoppingCart;
import java.util.Set;

public interface IShoppingCartRepository extends IRepository<ShoppingCart, String>
{
    public Set<ShoppingCart> getAll();
}
