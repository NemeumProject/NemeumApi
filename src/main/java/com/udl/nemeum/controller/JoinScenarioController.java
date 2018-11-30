package com.udl.nemeum.controller;

import com.udl.nemeum.dto.ScenarioDTO;
import com.udl.nemeum.dto.UserScenarioDTO;
import com.udl.nemeum.services.UserScenarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/joinScenario")
public class JoinScenarioController {

    @Autowired
    private UserScenarioService userScenarioService;

    @RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
    public UserScenarioDTO add(UriComponentsBuilder ucBuilder, @RequestBody UserScenarioDTO input) {

        return userScenarioService.add(input);

    }

    @RequestMapping(method = RequestMethod.DELETE)
    @Transactional
    public void deleteJoinScenario(UriComponentsBuilder ucBuilder, @RequestBody UserScenarioDTO input) {
        userScenarioService.deleteUserScenario(input.getIdUser(), input.getIdScenario());
    }
}
