package com.example.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping(path = "/hello")
    public String hello(){
        var html = "<html> <body> <h1> Hello Spring boot </h1> </body> </html>";
        return html;
    }
    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
        @PathVariable String message,
        @PathVariable int age,
        @PathVariable boolean isMan
    ){
        System.out.println("echo message : "+message);
        System.out.println("echo age : "+age);
        System.out.println("echo isMan : "+isMan);

        return message.toUpperCase();
    }
}
