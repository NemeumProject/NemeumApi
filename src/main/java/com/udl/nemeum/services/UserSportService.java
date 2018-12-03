package com.udl.nemeum.services;

import com.udl.nemeum.dto.UserSportDTO;
import com.udl.nemeum.models.UserSportBO;
import com.udl.nemeum.repository.IndividualUserRepository;
import com.udl.nemeum.repository.SportRepository;
import com.udl.nemeum.repository.UserSportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userSportService")
public class UserSportService {

    @Autowired
    private UserSportRepository userSportRepository;

    @Autowired
    private IndividualUserRepository individualUserRepository;

    @Autowired
    private SportRepository sportRepository;

    public UserSportDTO add(UserSportDTO dto){
        UserSportBO userSportBO = new UserSportBO();

        userSportBO.setSportLevel(sportRepository.findByidSport(dto.getIdSport()));
        userSportBO.setUserLevel(individualUserRepository.findByidIndividualUser(dto.getIdUser()));
        userSportBO.setLevel(dto.getLevel());

        return new UserSportDTO(userSportRepository.save(userSportBO));
    }

    public void deleteUserSport(Integer idUser, Integer idSport) {
        if(idSport != null && idUser != null){
            UserSportBO userSportBO = userSportRepository.findUserSportBySport(idUser, idSport);
            userSportRepository.delete(userSportBO);
        }

    }
}
