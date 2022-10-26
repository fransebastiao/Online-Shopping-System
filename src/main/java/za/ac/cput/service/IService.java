package za.ac.cput.service;

import java.util.Set;

public interface IService<X, ID>
{
    X save(X x);
    X read(ID id);
    boolean delete (ID id);
    Set<X> findAll();

}
