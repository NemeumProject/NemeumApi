package com.udl.nemeum.services;

import com.udl.nemeum.dto.IndividualUserDTO;
import com.udl.nemeum.models.IndividualUserBO;
import com.udl.nemeum.repository.CompanyUserRepository;
import com.udl.nemeum.repository.IndividualUserRepository;
import com.udl.nemeum.repository.TrainerUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("individualUserService")
public class IndividualUserService {

    @Autowired
    private IndividualUserRepository individualUserRepository;

    @Autowired
    private CompanyUserRepository companyUserRepository;

    @Autowired
    private TrainerUserRepository trainerUserRepository;

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

    public Map<String, Object> addUser(IndividualUserDTO input){
        Map<String, Object> map = new HashMap<>();
        if(individualUserRepository.findByemail(input.getEmail()) != null || companyUserRepository.findByemail(input.getEmail()) != null
                || trainerUserRepository.findByemail(input.getEmail()) != null){
            map.put("exist", true);
        }else{
            map.put("exist", false);
            IndividualUserBO individualUserBO = toBO(input);

            IndividualUserBO finalUserBO = individualUserRepository.save(individualUserBO);
            map.put("dto", new IndividualUserDTO(finalUserBO));
        }
        return map;
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

    public List<IndividualUserDTO> getUsersByScenario(Integer id) {

        List<IndividualUserBO> individualUserBOList = individualUserRepository.findUsersByScenario(id);
        List<IndividualUserDTO> individualUserDTOList = new ArrayList<>();
        for(IndividualUserBO individualUserBO : individualUserBOList){
            individualUserDTOList.add(new IndividualUserDTO(individualUserBO));
        }

        return individualUserDTOList;
    }

    public List<IndividualUserDTO> getUsersByTeam(Integer id){
        List<IndividualUserBO> individualUserBOList = individualUserRepository.findUsersByTeam(id);
        List<IndividualUserDTO> individualUserDTOList = new ArrayList<>();
        for(IndividualUserBO individualUserBO : individualUserBOList){
            individualUserDTOList.add(new IndividualUserDTO(individualUserBO));
        }

        return individualUserDTOList;
    }

    public List<IndividualUserDTO> getUsersBySport(Integer id){
        List<IndividualUserBO> individualUserBOList = individualUserRepository.findUsersBySport(id);
        List<IndividualUserDTO> individualUserDTOList = new ArrayList<>();
        for(IndividualUserBO individualUserBO : individualUserBOList){
            individualUserDTOList.add(new IndividualUserDTO(individualUserBO));
        }

        return individualUserDTOList;
    }
}
