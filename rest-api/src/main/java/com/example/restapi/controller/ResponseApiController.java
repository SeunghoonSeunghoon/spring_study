package com.example.restapi.controller;


import lombok.extern.slf4j.Slf4j;
import model.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController // 응답값을 Json 으로 내리는 선언
//@Controller
@RequestMapping("/api/v1")
public class ResponseApiController {
    //http://localhost:8080/api/v1 주소로 매칭
    @GetMapping("")
    //@RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<UserRequest> user(){
        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(10);
        user.setEmail("asdf@gmail.com");

        log.info("user : {}", user);

        var response = ResponseEntity // 원하는 형태의 에러를 내린다
                .status(HttpStatus.BAD_REQUEST) // 응답을 바꿀 수 있는.
                .header("x-custom","hi")
                .body(user);
        //  user.toString(); // 클래스를 리턴하면 스프링 부트가 알아서 Json 으로 바꿔준다. 응답까지
        return response;
    }
}
