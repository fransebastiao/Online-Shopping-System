/*
UserRoleController.java
This is a controller class for User Role
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
import za.ac.cput.domain.UserRole;
import za.ac.cput.factory.UserRoleFactory;
import za.ac.cput.service.UserRoleService;

import java.util.Set;

@RestController
@RequestMapping("online-shopping-system/user-role/")
@Slf4j
public class UserRoleController {
    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping("save")
    public ResponseEntity<UserRole> save(@RequestBody UserRole userRole) {
        log.info("Save request: {}", userRole);
        UserRole validatedUserRole;
        try {
            validatedUserRole = UserRoleFactory.createUserRole(userRole.getRoleId(), userRole.getRoleType());
        } catch (IllegalArgumentException e) {
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        UserRole save = userRoleService.save(validatedUserRole);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request{}", id);
        this.userRoleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<UserRole> readId(@PathVariable String id) {
        log.info("Read request: {}", id);
        UserRole userRole = this.userRoleService.read(id);
        return ResponseEntity.ok(userRole);
    }

    @GetMapping("all")
    public ResponseEntity<Set<UserRole>> findAll() {
        Set<UserRole> userRoles = this.userRoleService.findAll();
        return ResponseEntity.ok(userRoles);
    }

}
