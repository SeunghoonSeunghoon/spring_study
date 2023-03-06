package com.example.exception.exception;

import com.example.exception.controller.RestApiBController;
import com.example.exception.controller.RestApiController;
import lombok.extern.slf4j.Slf4j;
import model.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice(basePackageClasses = {RestApiBController.class, RestApiController.class})
public class RestApiExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity exception(
            Exception e
    ){
        log.error("RestApiExceptionHandler",e);

        return ResponseEntity.status(200).build();
    }
    @ExceptionHandler(value = {IndexOutOfBoundsException.class})
    public ResponseEntity outOfBound(
        IndexOutOfBoundsException e
            ){
        log.error("RestApiExceptionHandler", e);
        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = {NoSuchElementException.class}) // 어떤 에러를 예외처리할지
    public ResponseEntity<Api> noSuchElement( // 동일
            NoSuchElementException e
    ){
        log.error("", e);

        var response = Api.builder() // 위 에러가 뜨면 어떤 에러를 띄울지
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build()
                ;

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response)
                ;
    }
}
