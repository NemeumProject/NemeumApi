package com.udl.nemeum.services;

import com.udl.nemeum.dto.LoginDTO;
import com.udl.nemeum.models.CompanyUserBO;
import com.udl.nemeum.models.IndividualUserBO;
import com.udl.nemeum.models.TrainerUserBO;
import com.udl.nemeum.repository.CompanyUserRepository;
import com.udl.nemeum.repository.IndividualUserRepository;
import com.udl.nemeum.repository.TrainerUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginService {

    @Autowired
    private IndividualUserRepository individualUserRepository;

    @Autowired
    private CompanyUserRepository companyUserRepository;

    @Autowired
    private TrainerUserRepository trainerUserRepository;

    public Boolean login(LoginDTO dto){
        Boolean login = false;
        if(individualUserRepository.findByemail(dto.getEmail()) != null){
            IndividualUserBO currentUser = individualUserRepository.findByemail(dto.getEmail());
            if(dto.getPassword().equals(currentUser.getPassword())){
                login = true;
            }
        }else if(trainerUserRepository.findByemail(dto.getEmail()) != null){
            TrainerUserBO currentUser = trainerUserRepository.findByemail(dto.getEmail());
            if(dto.getPassword().equals(currentUser.getPassword())){
                login = true;
            }
        }else if(companyUserRepository.findByemail(dto.getEmail()) != null){
            CompanyUserBO currentUser = companyUserRepository.findByemail(dto.getEmail());
            if(dto.getPassword().equals(currentUser.getPassword())){
                login = true;
            }
        }
        return login;
    }
}
