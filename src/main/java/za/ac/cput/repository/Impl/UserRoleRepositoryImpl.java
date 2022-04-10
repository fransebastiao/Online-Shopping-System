package za.ac.cput.repository.Impl;
/*
UserRoleRepositoryImpl.java
User Role Repository Singleton implementation
Author: Siphelele Nyathi 218334028
Date: O4.04.2022
 */

import za.ac.cput.entity.User;
import za.ac.cput.entity.UserRole;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.repository.UserRoleRepository;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class UserRoleRepositoryImpl implements UserRoleRepository {

    private Set <UserRole> userRoleSet;


    private static UserRoleRepository repository = null;

    private UserRoleRepositoryImpl(){
        this.userRoleSet = new HashSet<>();
    }

    //Singleton
    public static UserRoleRepository getRepository(){

        if(repository == null){
            repository = new UserRoleRepositoryImpl();
        }
        return repository;
    }

    @Override
    public UserRole create(UserRole userRole) {

        this.userRoleSet.add(userRole);
        return userRole;
    }

    @Override
    public UserRole update(UserRole userRole) {

        delete(userRole.getRoleId());
        this.userRoleSet.add(userRole);
        return userRole;
    }

    @Override
    public UserRole read(String id) {

        for (UserRole userRole : this.userRoleSet)
            if (userRole.getRoleId().equalsIgnoreCase(id))
                return userRole;
                    return null;
    }

    @Override
    public boolean delete(String id) {
        UserRole deleteRole = read(id);
        if (deleteRole == null){
            try {
                throw new FileNotFoundException("Ooops! no role associated with that ID");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        this.userRoleSet.remove(deleteRole);
        return true;
    }

    @Override
    public Set<UserRole> getAll() {
        return userRoleSet;
    }
}
