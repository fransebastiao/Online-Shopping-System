//25.10.2022
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Account;
import za.ac.cput.factory.AccountFactory;
import za.ac.cput.service.AccountService;

import java.util.Set;

@RestController
@RequestMapping("online-shopping-system/account/")
@Slf4j
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("save")
    public ResponseEntity<Account> save(@RequestBody Account account) {
        log.info("Save request: {}", account);
        Account validatedAccount;
        try {
            validatedAccount = AccountFactory.createAccount(account.getAccountId(), account.getOpenDate(), account.getCloseDate());
        } catch (IllegalArgumentException e) {
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Account save = accountService.save(validatedAccount);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request{}", id);
        this.accountService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Account> readId(@PathVariable String id) {
        log.info("Read request: {}", id);
        Account account = this.accountService.read(id);
        return ResponseEntity.ok(account);
    }

    @GetMapping("all")
    public ResponseEntity<Set<Account>> findAll() {
        Set<Account> accounts = this.accountService.findAll();
        return ResponseEntity.ok(accounts);
    }

}
