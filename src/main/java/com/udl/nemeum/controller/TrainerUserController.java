package com.udl.nemeum.controller;

import com.udl.nemeum.dto.TrainerUserDTO;
import com.udl.nemeum.services.TrainerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/traineruser")
public class TrainerUserController {

    @Autowired
    private TrainerUserService trainerUserService;

    @RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TrainerUserDTO>> getAllUsers() throws IOException {
        List<TrainerUserDTO> users = trainerUserService.getAllUsers();
        return new ResponseEntity<List<TrainerUserDTO>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/{idUser}", method = RequestMethod.DELETE)
    @Transactional
    public void deleteUser(@PathVariable("idUser") Integer id) {
        trainerUserService.deleteUser(id);
    }

    @RequestMapping(value = "/{idUser}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public TrainerUserDTO getUser(@PathVariable("idUser") Integer id) {
        return trainerUserService.getUser(id);
    }


    @RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
    public TrainerUserDTO add(UriComponentsBuilder ucBuilder, @RequestBody TrainerUserDTO input) {

        return trainerUserService.addUser(input);

    }

    @RequestMapping(method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE})
    public TrainerUserDTO modify(UriComponentsBuilder ucBuilder, @RequestBody TrainerUserDTO input) {

        return trainerUserService.modifyUser(input);

    }

    @RequestMapping(value = "/sport/{idSport}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public List<TrainerUserDTO> getUsersBySport(@PathVariable("idSport") Integer id) {
        return trainerUserService.getTrainersBySport(id);
    }
}
