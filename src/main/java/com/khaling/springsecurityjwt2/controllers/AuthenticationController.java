package com.khaling.springsecurityjwt2.controllers;

import com.khaling.springsecurityjwt2.Entity.ApplicationUser;
import com.khaling.springsecurityjwt2.dto.RegistrationDto;
import com.khaling.springsecurityjwt2.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AuthenticationController {
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDto body){
        return authenticationService.registerUser(body.getUsername(),body.getPassword());
    }

}
