package za.ac.cput.repository;
/*
IRepository.java
Repository interface
Date: 08 / 04 / 2022
 */

public interface IRepository<T, ID> {
    T create(T t);
    T update(T t);
    T read(ID id);
    boolean delete(ID id);
}