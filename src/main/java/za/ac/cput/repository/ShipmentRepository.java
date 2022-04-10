package za.ac.cput.repository;

import java.util.HashSet;
import za.ac.cput.entity.Shipment;
import java.util.Set;

import java.util.HashSet;

public class ShipmentRepository implements IShipmentRepository
{
    private static ShipmentRepository repository = null;
    private Set<Shipment> ShipmentDB = null;

    private ShipmentRepository ()
    {
        ShipmentDB = new HashSet<Shipment>();
    }

    public static ShipmentRepository getRepository(){

        if (repository == null) {
            repository = new ShipmentRepository();

        }
        return repository;
    }
     @Override
    public Shipment create(Shipment shipment) {
        boolean success = ShipmentDB.add(shipment);
        if (!success)

            return null;
        return shipment;
    }
    @Override
    public Shipment read(String ShipmentId)
    {
        Shipment Shipment = ShipmentDB.stream().filter(s -> s.getShipmentId().equals(ShipmentId)).findAny().orElse( null);

        return Shipment;


        //for (ShoppingCart s: shoppingCartDB){

    }
    @Override
    public Shipment update(Shipment Shipment) {
        Shipment oldShipment = read(Shipment.getShipmentId());
        if (oldShipment != null) {
            ShipmentDB.remove(oldShipment);
            ShipmentDB.add(Shipment);
            return Shipment;
        }
        return null;
    }
    @Override
    public boolean delete(String ShipmentId)
    {
        Shipment ShipmentToDelete = read(ShipmentId);
        if(ShipmentToDelete == null)
            return false;
        ShipmentDB.remove(ShipmentToDelete);
        return true;

    }
    @Override
    public Set <Shipment> getAll()
    {
        return ShipmentDB;
    }


}
