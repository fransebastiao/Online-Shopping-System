package za.ac.cput.repository.Impl;
/*
UserRepositoryImpl.java
User Repository Singleton implementation
Author: Siphelele Nyathi 218334028
Date: O4.04.2022
 */
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class UserRepositoryImpl implements UserRepository {

    private Set <User> userList;

    //static helps with singleton
    private static UserRepository repository = null;

    private UserRepositoryImpl(){
        this.userList = new HashSet<>();
    }

    //Singleton
    public static UserRepository getRepository(){

        if(repository == null){
            repository = new UserRepositoryImpl();
        }
            return repository;
    }

    @Override
    public User create(User user) {

        this.userList.add(user);
        return user;
    }

    @Override
    public User read(String s) {

        for (User user : this.userList)
            if (user.getUserId().equalsIgnoreCase(s))
                return user;
                    return null;
    }


    @Override
    public User update(User user) {

        delete(user.getUserId());
        this.userList.add(user);
        return user;
    }


    @Override
    public boolean delete(String id) {

        User deleteUser = read(id);
        if (deleteUser == null){
            try {
                throw new FileNotFoundException("Ooops! there's no user associated with that ID");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
                this.userList.remove(deleteUser);
            return true;
    }

    @Override
    public Set<User> getAll() {
        return userList;
    }
}
