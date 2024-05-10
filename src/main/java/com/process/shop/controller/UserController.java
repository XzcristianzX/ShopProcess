package com.process.shop.controller;

import com.process.shop.model.User;
import com.process.shop.service.User.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    // Endpoint para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(user));
    }

    // Endpoint para obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity
                .ok()
                .body(userService.findAllUsers());
    }

    // Endpoint para obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable @NotNull Long id) {
        return ResponseEntity
                .ok()
                .body(userService.getUserById(id));
    }


    // Endpoint para actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<User>updateUser(@PathVariable Long id, @RequestBody @Valid User user) {
        return ResponseEntity
                .ok()
                .body(userService.updateUser(user,id));
    }

    // Endpoint para eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
