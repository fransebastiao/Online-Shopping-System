package za.ac.cput.service.impl;
/*
Service Implementation for Account class
Author: Franciel Danilo de Carvalho Sebastiao
Student Number: 219466912
Date: 13/08/2022
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Account;
import za.ac.cput.repository.AccountRepository;
import za.ac.cput.service.AccountService;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;

    @Autowired
    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account save(Account account) {return this.repository.save(account);}

    @Override
    public Optional<Account> read(String s) {
        return Optional.empty();
    }

    @Override
    public void delete(Account account) {
        this.repository.delete(account);
    }

    @Override
    public List<Account> findAll() {
        return this.repository.findAll();
    }

    public void deleteById(String id) {
        repository.deleteById(id);
        Optional<Account> account = read(id);
        if (account.isPresent()) {
            delete(account.get());
        }
    }
}
