package com.udl.nemeum.services;

import com.udl.nemeum.dto.TrainerSportDTO;
import com.udl.nemeum.models.TrainerSportBO;
import com.udl.nemeum.repository.SportRepository;
import com.udl.nemeum.repository.TrainerSportRepository;
import com.udl.nemeum.repository.TrainerUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("trainerSportService")
public class TrainerSportService {

    @Autowired
    private TrainerSportRepository trainerSportRepository;

    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private TrainerUserRepository trainerUserRepository;

    public TrainerSportDTO add(TrainerSportDTO dto){
        TrainerSportBO trainerSportBO = new TrainerSportBO();

        trainerSportBO.setTrainer(trainerUserRepository.findByidTrainerUser(dto.getIdTrainer()));
        trainerSportBO.setSportTrainer(sportRepository.findByidSport(dto.getIdSport()));
        trainerSportBO.setExperience(dto.getExperience());

        return new TrainerSportDTO(trainerSportRepository.save(trainerSportBO));
    }

    public void deleteTeamUser(Integer idTrainer, Integer idSport) {
        if(idTrainer != null && idSport != null){
            TrainerSportBO trainerSportBO = trainerSportRepository.findTrainerSport(idTrainer, idSport);
            trainerSportRepository.delete(trainerSportBO);
        }

    }
}
