package com.blog.blogapplication.Event;

import com.blog.blogapplication.payloads.UserDTO;
import com.blog.blogapplication.services.Impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EventListnerTest {
     @Autowired
     private UserServiceImpl service;
     @Autowired
     private EventListner listener;

     @Test
     public void publishing(){
          UserDTO userDTO =UserDTO.builder().name("riya").about("developer").email("riya@gmail.com").build();
          UserAddedEvent userAddedEvent = new UserAddedEvent(userDTO);
          service.publishUserEvent(userAddedEvent);
          verify(listener,times(1)).handleEvent(userAddedEvent);
     }
}