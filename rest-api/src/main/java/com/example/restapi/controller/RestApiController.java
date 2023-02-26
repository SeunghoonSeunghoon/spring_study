package com.example.restapi.controller;

import model.BookQueryParam;
import org.springframework.web.bind.annotation.*;

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
}
