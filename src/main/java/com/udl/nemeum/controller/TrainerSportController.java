package com.udl.nemeum.controller;

import com.udl.nemeum.dto.TrainerSportDTO;
import com.udl.nemeum.services.TrainerSportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/trainersport")
public class TrainerSportController {

    @Autowired
    private TrainerSportService trainerSportService;

    @RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
    public TrainerSportDTO add(UriComponentsBuilder ucBuilder, @RequestBody TrainerSportDTO input) {

        return trainerSportService.add(input);

    }

    /*@RequestMapping(method = RequestMethod.DELETE)
    @Transactional
    public void deleteTrainerSport(UriComponentsBuilder ucBuilder, @RequestBody TrainerSportDTO input) {
        trainerSportService.deleteTeamUser(input.getId_trainer_user(), input.getId_sport_training_type());
    }*/
}
