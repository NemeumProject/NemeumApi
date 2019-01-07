package com.udl.nemeum.controller;

import com.udl.nemeum.dto.ScenarioDTO;
import com.udl.nemeum.dto.UserScenarioDTO;
import com.udl.nemeum.services.UserScenarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/joinScenario")
public class JoinScenarioController {

    @Autowired
    private UserScenarioService userScenarioService;

    @RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
    public UserScenarioDTO add(UriComponentsBuilder ucBuilder, @RequestBody UserScenarioDTO input) {

        return userScenarioService.add(input);

    }

    @RequestMapping(value = "/{idUser}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<UserScenarioDTO>> getBookings(@PathVariable("idUser") Integer id) {
        List<UserScenarioDTO> bookings = userScenarioService.findByIdUser(id);
        return new ResponseEntity<List<UserScenarioDTO>>(bookings, HttpStatus.OK);
    }

    @RequestMapping(value = "/{userScenario}", method = RequestMethod.DELETE)
    @Transactional
    public void deleteJoinScenario(@PathVariable("userScenario") Integer id) {
        userScenarioService.deleteUserScenario(id);
    }
}
