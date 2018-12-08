package com.udl.nemeum.services;

import com.udl.nemeum.dto.LoginDTO;
import com.udl.nemeum.models.IndividualUserBO;
import com.udl.nemeum.repository.IndividualUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginService {

    @Autowired
    private IndividualUserRepository individualUserRepository;

    public Boolean login(LoginDTO dto){
        Boolean login = false;
        if(individualUserRepository.findByusername(dto.getUsername()) == null){
            login = false;
        }else{
            IndividualUserBO currentUser = individualUserRepository.findByusername(dto.getUsername());
            if(dto.getPassword().equals(currentUser.getPassword())){
                login = true;
            }
        }

        return login;
    }
}
