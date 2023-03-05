package com.example.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import model.BookQueryParam;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping(path = "/hello")
    public String hello(){
        var html = "<html> <body> <h1> Hello Spring boot </h1> </body> </html>";
        return html;
    }
    @GetMapping(path = "/test")
    public String test1(){
        var html = "<html> <body> <h1> Test~~~ </h1> </body> </html>";
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

    @GetMapping(path = "/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam String issued_day
            ){
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issued_day);

    }

    @GetMapping(path = "/book2")
    public void queryParamDto(
            BookQueryParam bookQueryParam
    ){
        System.out.println(bookQueryParam);
    }

    @DeleteMapping(path = {
            "/user/{userName}/delete",
            "/user/{userName}/del"
        }
    )
    public void delete(
            @PathVariable String userName
    ){
        log.info("user-name : {}", userName);
    }
}
