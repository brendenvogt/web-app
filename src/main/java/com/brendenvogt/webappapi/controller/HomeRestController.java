package com.brendenvogt.webappapi.controller;

import com.brendenvogt.webappapi.model.HelloWorld;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HomeRestController {

    @GetMapping
    public ResponseEntity<HelloWorld> getHelloWorld() {
        final HelloWorld helloWorld = HelloWorld.builder()
                .name("Brenden")
                .greeting("Hello World")
                .build();
        return ResponseEntity.of(Optional.of(helloWorld));
    }
}
