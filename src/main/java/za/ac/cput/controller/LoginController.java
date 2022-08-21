package za.ac.cput.controller;
/*
Online Shopping System
Lihle Langa 217181147
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Login;
import za.ac.cput.service.LoginService;
import javax.validation.Valid;
import java.util.Set;


@RestController
@RequestMapping("online-shopping-system/account")
@Slf4j
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("save")
    public ResponseEntity<Login> save(@Valid @RequestBody Login login){
        Login save = this.loginService.save(login);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request{}", id);
        this.loginService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Login> read(@PathVariable String id){
        log.info("Read request: {}", id);
        Login login = this.loginService.read(id);
        return ResponseEntity.ok(login);
    }
    @GetMapping("all")
    public ResponseEntity<Set<Login>> findAll(){
        Set<Login> login = this.loginService.findAll();
        return ResponseEntity.ok(login);
    }
}
