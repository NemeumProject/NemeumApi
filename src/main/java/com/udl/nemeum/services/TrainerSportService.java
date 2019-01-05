package com.udl.nemeum.services;

import com.udl.nemeum.dto.FilterTrainerServiceDTO;
import com.udl.nemeum.dto.TrainerSportDTO;
import com.udl.nemeum.models.SportBO;
import com.udl.nemeum.models.TrainerSportBO;
import com.udl.nemeum.models.TrainerUserBO;
import com.udl.nemeum.repository.SportRepository;
import com.udl.nemeum.repository.TrainerSportRepository;
import com.udl.nemeum.repository.TrainerSportRepositoryImpl;
import com.udl.nemeum.repository.TrainerUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("trainerSportService")
public class TrainerSportService {

    @Autowired
    private TrainerSportRepository trainerSportRepository;

    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private TrainerUserRepository trainerUserRepository;

    @Autowired
    private TrainerSportRepositoryImpl trainerSportRepositoryImpl;

    public TrainerSportDTO add(TrainerSportDTO dto){
        TrainerSportBO trainerSportBO = new TrainerSportBO();

        trainerSportBO.setId_trainer_user(trainerUserRepository.findByidTrainerUser(dto.getId_trainer_user()));
        trainerSportBO.setId_sport_training_type(sportRepository.findByidSport(dto.getId_sport_training_type()));
        trainerSportBO.setTraining_address(dto.getTraining_address());
        trainerSportBO.setTraining_price(dto.getTraining_price());
        trainerSportBO.setTraining_city(dto.getTraining_city());
        trainerSportBO.setTraining_start(dto.getTraining_start());
        trainerSportBO.setTraining_end(dto.getTraining_end());
        trainerSportBO.setTraining_desc(dto.getTraining_desc());

        return new TrainerSportDTO(trainerSportRepository.save(trainerSportBO));
    }

    public void delete(Integer idService) {
        if(idService != null){
            trainerSportRepository.deleteById(idService);
        }

    }

    public List<TrainerSportDTO> findTrainerServices(Integer idTrainer){
        List<TrainerSportBO> bo = trainerSportRepositoryImpl.findServices(idTrainer);
        return toDTO(bo);
    }

    public TrainerSportDTO findOneService(Integer idService){
        TrainerSportBO bo = trainerSportRepository.findByidTrainingServicePost(idService);

        return new TrainerSportDTO(bo);
    }

    public TrainerSportDTO modify(TrainerSportDTO input) {
        TrainerSportBO trainerSportBO = trainerSportRepository.findByidTrainingServicePost(input.getId_training_service_post());
        if(input.getId_sport_training_type() != null){
            trainerSportBO.setId_sport_training_type(sportRepository.findByidSport(input.getId_sport_training_type()));
        }
        if(input.getId_trainer_user() != null){
            trainerSportBO.setId_trainer_user(trainerUserRepository.findByidTrainerUser(input.getId_trainer_user()));
        }

        if(input.getTraining_address() != null){
            trainerSportBO.setTraining_address(input.getTraining_address());
        }
        if(input.getTraining_city() != null){
            trainerSportBO.setTraining_city(input.getTraining_city());
        }
        if (input.getTraining_desc() != null){
            trainerSportBO.setTraining_desc(input.getTraining_desc());
        }

        if(input.getTraining_end() != null){
            trainerSportBO.setTraining_end(input.getTraining_end());
        }

        if(input.getTraining_price() != null){
            trainerSportBO.setTraining_price(input.getTraining_price());
        }

        if(input.getTraining_start() != null){
            trainerSportBO.setTraining_start(input.getTraining_start());
        }

        TrainerSportBO finalTrainerSport = trainerSportRepository.save(trainerSportBO);

        return new TrainerSportDTO(finalTrainerSport);
    }

    public List<TrainerSportDTO> findAll() {
        List<TrainerSportBO> trainerSportBOList = trainerSportRepository.findAll();
        return toDTO(trainerSportBOList);
    }

    public List<TrainerSportDTO> filter(FilterTrainerServiceDTO filter){
        String trainer = null;
        String city = null;
        Double price = null;
        Integer sport = null;

        if(filter.getName() != null){
            trainer = filter.getName();
        }

        if(filter.getCity() != null){
            city = filter.getCity();
        }

        if(filter.getPrice() != null){
            price = filter.getPrice();
        }

        if(filter.getSport_id() != null){
            sport = filter.getSport_id();
        }

        List<TrainerSportBO> trainerService = trainerSportRepositoryImpl.filter(trainer, city, price, sport);

        return toDTO(trainerService);
    }

    public List<TrainerSportDTO> toDTO(List<TrainerSportBO> trainerSportBOList){
        List<TrainerSportDTO> trainerSportDTOList = new ArrayList<>();
        for(TrainerSportBO trainerSportBO : trainerSportBOList){
            trainerSportDTOList.add(new TrainerSportDTO(trainerSportBO));
        }

        return trainerSportDTOList;
    }
}
