package za.ac.cput.service.impl;
/*
UserServiceImpl.java
This is an implementation for User Services
Siphelele Nyathi 218334028
14.08.2022
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.service.UserService;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository){
        this.repository =  repository;
    }

    @Override
    public User save(User user) {
        return this.repository.save(user);
    }

    @Override
    public User read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(String id) {
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Set<User> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}


