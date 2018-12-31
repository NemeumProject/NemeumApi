package com.udl.nemeum.controller;

import com.udl.nemeum.dto.TrainerSportDTO;
import com.udl.nemeum.services.TrainerSportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/trainersport")
public class TrainerSportController {

    @Autowired
    private TrainerSportService trainerSportService;


    @RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TrainerSportDTO>> list(UriComponentsBuilder ucBuilder) {
        List<TrainerSportDTO> listTrainerSport = trainerSportService.findAll();
        return new ResponseEntity<List<TrainerSportDTO>>(listTrainerSport, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
    public TrainerSportDTO add(UriComponentsBuilder ucBuilder, @RequestBody TrainerSportDTO input) {

        return trainerSportService.add(input);

    }

    @RequestMapping(method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE})
    public TrainerSportDTO modify(UriComponentsBuilder ucBuilder, @RequestBody TrainerSportDTO input) {

        return trainerSportService.modify(input);

    }

    /*@RequestMapping(method = RequestMethod.DELETE)
    @Transactional
    public void deleteTrainerSport(UriComponentsBuilder ucBuilder, @RequestBody TrainerSportDTO input) {
        trainerSportService.deleteTeamUser(input.getId_trainer_user(), input.getId_sport_training_type());
    }*/
}
