package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.ShoppingCart;
import za.ac.cput.factory.ShoppingCartFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

class ShoppingCartRepositoryTest
{
    private static ShoppingCartRepository repository = ShoppingCartRepository.getRepository();
    private static ShoppingCart ShoppingCart = ShoppingCartFactory.createShoppingCart( "2684", 32535, 2587, "yyy/mm/dd" );



    @Test
    void create()
    {
        ShoppingCart created = repository.create(ShoppingCart);
        assertEquals(ShoppingCart.getCartId(),created.getCartId());
        System.out.println("Create: " + created);
    }

    @Test
    void read()
    {
        ShoppingCart read = repository.read(ShoppingCart.getCartId());
        assertNotNull(read) ;
        System.out.println("Read: " + read);
    }

    @Test
    void update()
    {
        ShoppingCart updated = new ShoppingCart.Builder().copy(ShoppingCart).setCartId("235655").setProductId(2365).setQuantity(2365).setDateAdded("yyy/mm/dd")
                .builder();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void delete()
    {
        boolean success = repository.delete(ShoppingCart.getCartId());

        assertTrue(success);

        System.out.println("Deleted: " + success);
    }

    @Test
    void getAll()
    {
        System.out.println("show all:" );
        System.out.println(repository.getAll());
    }
}
