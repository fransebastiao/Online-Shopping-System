package za.ac.cput.service.impl;
/*
UserServiceImpl.java
This is an implementation for User Role Services
Siphelele Nyathi 218334028
14.08.2022
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.UserRole;
import za.ac.cput.repository.UserRoleRepository;
import za.ac.cput.service.UserRoleService;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository roleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository roleRepository){
        this.roleRepository =  roleRepository;
    }

    @Override
    public UserRole save(UserRole userRole) {
        return this.roleRepository.save(userRole);
    }

    @Override
    public UserRole read(String id) {
        return this.roleRepository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(String id) {

        if(this.roleRepository.existsById(id)){
            this.roleRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Set<UserRole> findAll() {
        return this.roleRepository.findAll().stream().collect(Collectors.toSet());
    }
}

