package za.ac.cput.service.impl;
/*
Online Shopping System
Lihle Langa 217181147
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Login;
import za.ac.cput.repository.LoginRepository;
import za.ac.cput.service.LoginService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LoginServiceImpl implements LoginService {

@Autowired
private final LoginRepository repository;

    public LoginServiceImpl(LoginRepository repository) {
        this.repository = repository;
    }


    @Override
    public Login save(Login login) {
        return this.repository.save(login);
    }

    @Override
    public Login read(String s) {
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
    public Set<Login> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
