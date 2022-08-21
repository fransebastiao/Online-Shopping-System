package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Account;
import za.ac.cput.service.AccountService;
import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("online-shopping-system/account")
@Slf4j
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("save")
    public ResponseEntity<Account> save(@Valid @RequestBody Account account){
        Account save = this.accountService.save(account);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request{}", id);
        this.accountService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Account> read(@PathVariable String id){
        log.info("Read request: {}", id);
        Account account = this.accountService.read(id);
        return ResponseEntity.ok(account);
    }

    @GetMapping("all")
    public ResponseEntity<Set<Account>> findAll(){
        Set<Account> accounts = this.accountService.findAll();
        return ResponseEntity.ok(accounts);
    }

}
