package za.ac.cput.service;

import java.util.List;
import java.util.Optional;

public interface IService<X, ID>
{
    X save(X x);
    Optional<X> read(ID id);
    void delete (X x);
    List<X> findAll();
}
