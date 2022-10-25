/*
UserController.java
This is a controller class for User
Siphelele Nyathi 218334028
//25.10.2022
 */
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.service.UserService;

import java.util.Set;

@RestController
@RequestMapping("online-shopping-system/user/")
@Slf4j
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("save")
    public ResponseEntity<User> save(@RequestBody User user) {
        log.info("Save request: {}", user);
        User validatedUser;
        try {
            validatedUser = UserFactory.createUser(user.getUserId(), user.getName(), user.getEmail(), user.getPassword(), user.getAddress());
        } catch (IllegalArgumentException e) {
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        User save = userService.save(validatedUser);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request{}", id);
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<User> readId(@PathVariable String id) {
        log.info("Read request: {}", id);
        User user = this.userService.read(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("all")
    public ResponseEntity<Set<User>> findAll() {
        Set<User> user = this.userService.findAll();
        return ResponseEntity.ok(user);
    }

}
