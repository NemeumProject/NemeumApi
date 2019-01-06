package com.udl.nemeum.services;

import com.udl.nemeum.dto.UserScenarioDTO;
import com.udl.nemeum.models.IndividualUserBO;
import com.udl.nemeum.models.UserScenarioBO;
import com.udl.nemeum.repository.IndividualUserRepository;
import com.udl.nemeum.repository.ScenarioRepository;
import com.udl.nemeum.repository.UserScenarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userScenarioService")
public class UserScenarioService {

    @Autowired
    private UserScenarioRepository userScenarioRepository;

    @Autowired
    private IndividualUserRepository individualUserRepository;

    @Autowired
    private ScenarioRepository scenarioRepository;

    public UserScenarioDTO add(UserScenarioDTO dto){
        UserScenarioBO userScenarioBO = new UserScenarioBO();

        userScenarioBO.setScenarioBO(scenarioRepository.findByidScenario(dto.getIdScenario()));
        if(dto.getIdUser() != null){
            IndividualUserBO bo = individualUserRepository.findByidIndividualUser(dto.getIdUser());
            userScenarioBO.setUserBO(bo);
            userScenarioBO.setCustomerName(bo.getFirstName());
            userScenarioBO.setEmail(bo.getEmail());
            userScenarioBO.setPhone(bo.getPhone());
        }else{
            userScenarioBO.setEmail(dto.getEmail());
            userScenarioBO.setPhone(dto.getPhone());
            userScenarioBO.setCustomerName(dto.getNameCustomer());
        }
        userScenarioBO.setDateBooking(dto.getDateBooking());
        userScenarioBO.setEndScenario(dto.getEndScenario());
        userScenarioBO.setStartScenario(dto.getStartScenario());

        return new UserScenarioDTO(userScenarioRepository.save(userScenarioBO));
    }

    public List<UserScenarioDTO> findByIdUser(Integer idUser){
        List<UserScenarioBO> userScenarioBOList = userScenarioRepository.findBookingByUser(idUser);
        return toDTO(userScenarioBOList);
    }

    public List<UserScenarioDTO> toDTO(List<UserScenarioBO> userScenarioBOList){
        List<UserScenarioDTO> userScenarioDTOList = new ArrayList<>();
        for(UserScenarioBO bo : userScenarioBOList){
            userScenarioDTOList.add(new UserScenarioDTO(bo));
        }

        return userScenarioDTOList;
    }

    public void deleteUserScenario(Integer idUser, Integer idScenario) {
        if(idScenario != null && idUser != null){
            UserScenarioBO userScenarioBO = userScenarioRepository.findUserScenarioByScenario(idUser, idScenario);
            userScenarioRepository.delete(userScenarioBO);
        }

    }
}
