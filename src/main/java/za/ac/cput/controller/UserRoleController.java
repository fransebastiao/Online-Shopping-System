package za.ac.cput.controller;
/*
UserRoleController.java
This is a controller class for User Role
Siphelele Nyathi 218334028
21.08.2022
 */
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.UserRole;
import za.ac.cput.service.UserRoleService;
import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("online-shopping-system/role/")
@Slf4j
public class UserRoleController {

    private final UserRoleService roleService;

    @Autowired
    public UserRoleController(UserRoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("save")
    public ResponseEntity<UserRole> save(@RequestBody @Valid UserRole role){
        log.info("Save Request: {}", role);
        UserRole savedRole = roleService.save(role);
        return ResponseEntity.ok(savedRole);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<UserRole> read(@PathVariable @Valid String id){
        log.info("Read request: {}", id);
        UserRole role = this.roleService.read(id);
        return ResponseEntity.ok(role);
    }

    @DeleteMapping("delete/{user}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request{}", id);
        this.roleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("List all")
    public ResponseEntity<Set<UserRole>> findAll(){
        Set<UserRole> roleSet = this.roleService.findAll();
        return ResponseEntity.ok(roleSet);
    }
}
