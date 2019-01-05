package com.udl.nemeum.controller;

import com.udl.nemeum.dto.FilterTrainerServiceDTO;
import com.udl.nemeum.dto.TrainerSportDTO;
import com.udl.nemeum.dto.TrainerUserDTO;
import com.udl.nemeum.services.TrainerSportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.ArrayList;
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

    @RequestMapping(value = "/service/{idService}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TrainerSportDTO>> getService(@PathVariable("idService") Integer id) {
        List<TrainerSportDTO> listTrainerSport = new ArrayList<>();
        listTrainerSport.add(trainerSportService.findOneService(id));
        return new ResponseEntity<List<TrainerSportDTO>>(listTrainerSport, HttpStatus.OK);

    }

    @RequestMapping(value = "/{idUser}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TrainerSportDTO>> findOne(@PathVariable("idUser") Integer id) {
        List<TrainerSportDTO> listTrainerSport = trainerSportService.findTrainerServices(id);
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

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
    public List<TrainerSportDTO> search(UriComponentsBuilder ucBuilder, @RequestBody FilterTrainerServiceDTO input) {

        return trainerSportService.filter(input);

    }

    @RequestMapping(value = "/{idService}", method = RequestMethod.DELETE)
    @Transactional
    public void deleteTrainerSport(@PathVariable("idService") Integer id) {
        trainerSportService.delete(id);
    }
}
