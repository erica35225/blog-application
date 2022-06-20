package com.blog.blogapplication.Event;

import com.blog.blogapplication.entities.User;
import com.blog.blogapplication.payloads.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class UserAddedEvent extends ApplicationEvent {
    private UserDTO payload;

    public UserAddedEvent(UserDTO userDTO) {
        super(userDTO);
        this.payload = userDTO;
    }
}
