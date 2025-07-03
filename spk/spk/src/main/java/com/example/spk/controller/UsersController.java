package com.example.spk.controller;

import com.example.spk.payload.request.LoginRequest;
import com.example.spk.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private UsersServices usersServices;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody LoginRequest loginRequest){
        ResponseEntity<String> response = usersServices.register(loginRequest);
        return response;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        return usersServices.login(loginRequest);
    }

}
