/*
Service Implementation for Account class
Author: Franciel Danilo de Carvalho Sebastiao
Student Number: 219466912
//25.10.2022
 */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Account;
import za.ac.cput.repository.IAccountRepository;
import za.ac.cput.service.AccountService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final IAccountRepository repository;

    @Autowired
    public AccountServiceImpl(IAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account save(Account account) {
        return this.repository.save(account);
    }

    @Override
    public Account read(String s) {
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
    public Set<Account> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}

