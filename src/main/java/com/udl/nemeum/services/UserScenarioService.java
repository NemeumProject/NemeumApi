package com.udl.nemeum.services;

import com.udl.nemeum.dto.UserScenarioDTO;
import com.udl.nemeum.models.IndividualUserBO;
import com.udl.nemeum.models.UserScenarioBO;
import com.udl.nemeum.repository.IndividualUserRepository;
import com.udl.nemeum.repository.ScenarioRepository;
import com.udl.nemeum.repository.UserScenarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
        List<UserScenarioBO> listUserScenario = userScenarioRepository.findAll();

        Boolean authorizedBooking = true;
        UserScenarioDTO userScenarioDTO = null;
        for(UserScenarioBO booking : listUserScenario){
            if(dto.getStartScenario().equals(booking.getStartScenario()) && dto.getIdScenario().equals(booking.getScenarioBO().getIdScenario())){
                authorizedBooking = false;
            }else if(dto.getStartScenario().after(booking.getStartScenario()) && dto.getStartScenario().before(booking.getStartScenario()) && dto.getIdScenario().equals(booking.getScenarioBO().getIdScenario())){
                authorizedBooking = false;
            }else if(dto.getEndScenario().after(booking.getEndScenario()) && dto.getEndScenario().before(booking.getEndScenario()) && dto.getIdScenario().equals(booking.getScenarioBO().getIdScenario())){
                authorizedBooking = false;
            }else if(dto.getEndScenario().equals(booking.getEndScenario()) && dto.getIdScenario().equals(booking.getScenarioBO().getIdScenario())){
                authorizedBooking = false;
            }
        }

        if(authorizedBooking == true) {
            UserScenarioBO userScenarioBO = new UserScenarioBO();
            userScenarioBO.setScenarioBO(scenarioRepository.findByidScenario(dto.getIdScenario()));
            if(dto.getIdUser() != null){
                userScenarioBO.setUserBO(individualUserRepository.findByidIndividualUser(dto.getIdUser()));

            }
            userScenarioBO.setEmail(dto.getEmail());
            userScenarioBO.setPhone(dto.getPhone());
            userScenarioBO.setCustomerName(dto.getNameCustomer());
            userScenarioBO.setDateBooking(dto.getDateBooking());
            userScenarioBO.setEndScenario(dto.getEndScenario());
            userScenarioBO.setStartScenario(dto.getStartScenario());

            return new UserScenarioDTO(userScenarioRepository.save(userScenarioBO));
        }else{
           return  userScenarioDTO;
        }
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

    public void deleteUserScenario(Integer idUserScenario) {
        if(idUserScenario != null){
            userScenarioRepository.deleteById(idUserScenario);
        }
    }
}
