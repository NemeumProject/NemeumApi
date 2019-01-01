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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<List<TrainerUserDTO>> getUser(@PathVariable("idUser") Integer id) {
        List<TrainerUserDTO> trainer = new ArrayList<>();
        trainer.add(trainerUserService.getUser(id));
        return new ResponseEntity<List<TrainerUserDTO>>(trainer, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> add(UriComponentsBuilder ucBuilder, @RequestBody TrainerUserDTO input) {

        Map<String, Object> map = trainerUserService.addUser(input);
        if(map.get("exist").equals(true)){
            return new ResponseEntity<String>("User already exists", HttpStatus.UNAUTHORIZED);
        }else{
            TrainerUserDTO user = (TrainerUserDTO) map.get("dto");
            return new ResponseEntity<TrainerUserDTO>(user, HttpStatus.OK);
        }

    }

    @RequestMapping(method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE})
    public TrainerUserDTO modify(UriComponentsBuilder ucBuilder, @RequestBody TrainerUserDTO input) {

        return trainerUserService.modifyUser(input);

    }

    /*@RequestMapping(value = "/sport/{idSport}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public List<TrainerUserDTO> getUsersBySport(@PathVariable("idSport") Integer id) {
        return trainerUserService.getTrainersBySport(id);
    }*/
}
