package za.ac.cput.controller;
/*
UserController.java
This is a controller class for User
Siphelele Nyathi 218334028
21.08.2022
 */
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.service.UserService;
import javax.validation.Valid;
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
    public ResponseEntity<User> save(@RequestBody @Valid User user){
        log.info("Save Request: {}", user);
        User savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<User> read(@PathVariable @Valid String id){
        log.info("Read request: {}", id);
        User user = this.userService.read(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("delete/{user}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request{}", id);
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("List all")
    public ResponseEntity<Set<User>> findAll(){
        Set<User> userSet = this.userService.findAll();
        return ResponseEntity.ok(userSet);
    }
}
