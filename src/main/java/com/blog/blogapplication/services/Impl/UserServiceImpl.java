package com.blog.blogapplication.services.Impl;

import com.blog.blogapplication.Event.UserAddedEvent;
import com.blog.blogapplication.entities.User;
import com.blog.blogapplication.exceptions.ResourceNotFoundException;
import com.blog.blogapplication.payloads.ApiResponse;
import com.blog.blogapplication.payloads.UserDTO;
import com.blog.blogapplication.repositories.UserRepo;
import com.blog.blogapplication.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public UserDTO createUser(UserDTO userDto) {
        User user = modelMapper.map(userDto, User.class);
        this.userRepo.save(user);
      //  eventPublisher.publishAddUserEvent(userDto);
        publishUserEvent(new UserAddedEvent(userDto));
        return userDto;
    }

    public void publishUserEvent(UserAddedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public ApiResponse deleteUser(Long userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        this.userRepo.deleteById(userId);
        return new ApiResponse(String.format("user successfully deleted with Id: %s",userId),true);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        User updatedUser = this.userRepo.save(this.modelMapper.map(userDTO, User.class));
        return this.modelMapper.map(updatedUser, UserDTO.class);
    }

    @Override
    public UserDTO getUser(Long userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        UserDTO userDTO = this.modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOS = new ArrayList<>();
        this.userRepo.findAll().stream().forEach((user) -> {
            UserDTO userDTO = this.modelMapper.map(user, UserDTO.class);
            userDTOS.add(userDTO);
        });
        return userDTOS;
    }
}
