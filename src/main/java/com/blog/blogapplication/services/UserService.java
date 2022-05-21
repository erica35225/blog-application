package com.blog.blogapplication.services;

import com.blog.blogapplication.payloads.ApiResponse;
import com.blog.blogapplication.payloads.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);

    ApiResponse deleteUser(Long userId);

    UserDTO updateUser(UserDTO userDTO,Long userId);

    UserDTO getUser(Long userId);

    List<UserDTO> getAllUsers();

}
