/*
UserServiceImpl.java
This is an implementation for User Role Services
Siphelele Nyathi 218334028
//25.10.2022
 */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.UserRole;
import za.ac.cput.repository.IUserRoleRepository;
import za.ac.cput.service.UserRoleService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final IUserRoleRepository repository;

    @Autowired
    public UserRoleServiceImpl(IUserRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserRole save(UserRole userRole) {
        return this.repository.save(userRole);
    }

    @Override
    public UserRole read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public boolean delete(String s) {
        if (this.repository.existsById(s)) {
            this.repository.deleteById(s);
            return true;
        }
        return false;
    }


    @Override
    public Set<UserRole> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}


