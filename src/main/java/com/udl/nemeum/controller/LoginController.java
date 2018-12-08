package com.udl.nemeum.controller;

import com.udl.nemeum.dto.LoginDTO;
import com.udl.nemeum.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> add(UriComponentsBuilder ucBuilder, @RequestBody LoginDTO input) {

        if(loginService.login(input)){
            return new ResponseEntity<String>("Login", HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("", HttpStatus.UNAUTHORIZED);
        }
    }
}
