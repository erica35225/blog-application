package com.blog.blogapplication.controllers;

import com.blog.blogapplication.payloads.ApiResponse;
import com.blog.blogapplication.payloads.UserDTO;
import com.blog.blogapplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add-user")
    private ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO user = userService.createUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/find-user/{userId}")
    private ResponseEntity<UserDTO> getUser(@PathVariable Long userId) {
        UserDTO userDTO = userService.getUser(userId);
        return new ResponseEntity<>(userDTO, HttpStatus.FOUND);
    }

    @GetMapping("/all-users")
    private ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.FOUND);
    }

    @PutMapping("/update-user/{userId}")
    private ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable Long userId) {
        UserDTO updatedUserDTO = this.userService.updateUser(userDTO, userId);
        return new ResponseEntity<>(updatedUserDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-user/{userId}")
    private ResponseEntity<ApiResponse> deleteUser(@PathVariable @Valid Long userId) {
        ApiResponse apiResponse = this.userService.deleteUser(userId);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
