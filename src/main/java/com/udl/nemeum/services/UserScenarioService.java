package com.udl.nemeum.services;

import com.udl.nemeum.dto.UserScenarioDTO;
import com.udl.nemeum.models.UserScenarioBO;
import com.udl.nemeum.repository.IndividualUserRepository;
import com.udl.nemeum.repository.ScenarioRepository;
import com.udl.nemeum.repository.UserScenarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            userScenarioBO.setUserBO(individualUserRepository.findByidIndividualUser(dto.getIdUser()));
        }
        userScenarioBO.setDateBooking(dto.getDateBooking());
        userScenarioBO.setEmail(dto.getEmail());
        userScenarioBO.setPhone(dto.getPhone());
        userScenarioBO.setEndScenario(dto.getEndScenario());
        userScenarioBO.setStartScenario(dto.getStartScenario());

        return new UserScenarioDTO(userScenarioRepository.save(userScenarioBO));
    }

    public void deleteUserScenario(Integer idUser, Integer idScenario) {
        if(idScenario != null && idUser != null){
            UserScenarioBO userScenarioBO = userScenarioRepository.findUserScenarioByScenario(idUser, idScenario);
            userScenarioRepository.delete(userScenarioBO);
        }

    }
}
