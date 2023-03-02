package com.example.restapi.controller;

import model.BookRequest;
import model.UserClass;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public String post(
       @RequestBody BookRequest bookRequest

    ){
        System.out.println(bookRequest);
        return bookRequest.toString();
    }
    @PostMapping("/post2")
    public void user(
            @RequestBody UserClass userClass
    ){
        System.out.println(userClass);
    }
}
