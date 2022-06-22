package com.blog.blogapplication.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
public class PostController {
    @GetMapping("/post")
    public List<Object> getPost(Long id){
        return Collections.emptyList();
    }
}
