package com.udl.nemeum.controller;

import com.udl.nemeum.dto.IndividualUserDTO;
import com.udl.nemeum.services.IndividualUserService;
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
@RequestMapping("/user")
public class IndividualUserController {

    @Autowired
    private IndividualUserService individualUserService;

    @RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<IndividualUserDTO>> getAllUsers() throws IOException {
        List<IndividualUserDTO> scenarios = individualUserService.getAllUsers();
        return new ResponseEntity<List<IndividualUserDTO>>(scenarios, HttpStatus.OK);
    }

    @RequestMapping(value = "/{idUser}", method = RequestMethod.DELETE)
    @Transactional
    public void deleteUser(@PathVariable("idUser") Integer id) {
        individualUserService.deleteUser(id);
    }

    @RequestMapping(value = "/{idUser}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public IndividualUserDTO getUser(@PathVariable("idUser") Integer id) {
        return individualUserService.getUser(id);
    }

    @RequestMapping(value = "/scenario/{idScenario}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public List<IndividualUserDTO> getUsersByScenario(@PathVariable("idScenario") Integer id) {
        return individualUserService.getUsersByScenario(id);
    }

    @RequestMapping(value = "/team/{idTeam}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public List<IndividualUserDTO> getUsersByTeam(@PathVariable("idTeam") Integer id) {
        return individualUserService.getUsersByTeam(id);
    }

    @RequestMapping(value = "/sport/{idSport}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public List<IndividualUserDTO> getUsersBySport(@PathVariable("idSport") Integer id) {
        return individualUserService.getUsersBySport(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
    public IndividualUserDTO add(UriComponentsBuilder ucBuilder, @RequestBody IndividualUserDTO input) {

        return individualUserService.addUser(input);

    }

    @RequestMapping(method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE})
    public IndividualUserDTO modify(UriComponentsBuilder ucBuilder, @RequestBody IndividualUserDTO input) {

        return individualUserService.modifyUser(input);

    }
}
