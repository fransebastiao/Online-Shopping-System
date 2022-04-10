package za.ac.cput.repository;

import java.util.HashSet;
import za.ac.cput.entity.ShoppingCart;
import java.util.Set;

public class ShoppingCartRepository implements IShoppingCartRepository
{
    private static ShoppingCartRepository repository = null;
    private Set<ShoppingCart> shoppingCartDB = null;

    private ShoppingCartRepository ()
    {
        shoppingCartDB = new HashSet<ShoppingCart>();
    }

    public static ShoppingCartRepository getRepository(){

        if (repository == null) {
            repository = new ShoppingCartRepository();

        }
        return repository;
    }
    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
        boolean success = shoppingCartDB.add(shoppingCart);
        if (!success)

            return null;
        return shoppingCart;
    }
    @Override
    public ShoppingCart read(String ShoppingCartId)
    {
        ShoppingCart shoppingCart = shoppingCartDB.stream().filter(s -> s.getCartId().equals(ShoppingCartId)).findAny().orElse( null);
        return shoppingCart;


    }

    @Override

    public ShoppingCart update(ShoppingCart shoppingCart) {
        ShoppingCart oldShoppingCart = read(shoppingCart.getCartId());
        if (oldShoppingCart != null) {
            shoppingCartDB.remove(oldShoppingCart);
            shoppingCartDB.add(shoppingCart);
            return shoppingCart;
        }
        return null;
    }

    @Override
    public boolean delete(String shoppingCartId)
    {
        ShoppingCart ShoppingCartToDelete = read(shoppingCartId);
        if(ShoppingCartToDelete == null)
            return false;
        shoppingCartDB.remove(ShoppingCartToDelete);
        return true;

    }
    @Override
    public Set <ShoppingCart> getAll()
    {
        return shoppingCartDB;
    }


}
