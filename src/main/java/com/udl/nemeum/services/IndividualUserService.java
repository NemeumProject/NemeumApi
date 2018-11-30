package com.udl.nemeum.services;

import com.udl.nemeum.dto.IndividualUserDTO;
import com.udl.nemeum.dto.ScenarioDTO;
import com.udl.nemeum.models.IndividualUserBO;
import com.udl.nemeum.models.ScenarioBO;
import com.udl.nemeum.repository.IndividualUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("individualUserService")
public class IndividualUserService {

    @Autowired
    private IndividualUserRepository individualUserRepository;

    public List<IndividualUserDTO> getAllUsers(){
        List<IndividualUserBO> individualUserBOS = individualUserRepository.findAll();
        return toDTO(individualUserBOS);
    }

    private List<IndividualUserDTO> toDTO(List<IndividualUserBO> individualUserBOS) {

        List<IndividualUserDTO> individualUserDTOS = new ArrayList<>();
        for(IndividualUserBO individualUserBO : individualUserBOS ){
            individualUserDTOS.add(new IndividualUserDTO(individualUserBO));
        }
        return individualUserDTOS;
    }

    public IndividualUserDTO getUser(Integer id){
        return new IndividualUserDTO(individualUserRepository.findByidIndividualUser(id));
    }

    public IndividualUserDTO addUser(IndividualUserDTO input){
        IndividualUserBO individualUserBO = toBO(input);

        IndividualUserBO finalUserBO = individualUserRepository.save(individualUserBO);

        return new IndividualUserDTO(finalUserBO);
    }

    public  IndividualUserDTO modifyUser(IndividualUserDTO input){
        IndividualUserBO individualUserBO = toBO(input);
        individualUserBO.setIdIndividualUser(input.getIdIndividualUser());

        IndividualUserBO finalUser = individualUserRepository.save(individualUserBO);

        return new IndividualUserDTO(finalUser);
    }

    public void deleteUser(Integer id){
        if(id != null){
            individualUserRepository.deleteById(id);
        }

    }

    public IndividualUserBO toBO(IndividualUserDTO dto){
        IndividualUserBO individualUserBO = new IndividualUserBO();
        individualUserBO.setAddress(dto.getAddress());
        individualUserBO.setCity(dto.getCity());
        individualUserBO.setEmail(dto.getEmail());
        individualUserBO.setFirstName(dto.getFirstName());
        individualUserBO.setFreeFacility(dto.getFreeFacility());
        individualUserBO.setFreeTraining(dto.getFreeTraining());
        individualUserBO.setLastSurname(dto.getLastSurname());
        individualUserBO.setMiddleSurname(dto.getMiddleSurname());
        individualUserBO.setPassword(dto.getPassword());
        individualUserBO.setPhone(dto.getPhone());
        individualUserBO.setPostalCode(dto.getPostalCode());
        individualUserBO.setPremium(dto.getPremium());
        individualUserBO.setRentedHours(dto.getRentedHours());
        individualUserBO.setSsn(dto.getSsn());
        individualUserBO.setTrainedHours(dto.getTrainedHours());
        individualUserBO.setUsername(dto.getUsername());

        return individualUserBO;
    }
}
