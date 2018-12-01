package com.udl.nemeum.controller;

import com.udl.nemeum.dto.TeamUserDTO;
import com.udl.nemeum.services.TeamUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/joinTeam")
public class JoinTeamController {

    @Autowired
    private TeamUserService teamUserService;

    @RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
    public TeamUserDTO add(UriComponentsBuilder ucBuilder, @RequestBody TeamUserDTO input) {

        return teamUserService.add(input);

    }

    @RequestMapping(method = RequestMethod.DELETE)
    @Transactional
    public void deleteJoinTeam(UriComponentsBuilder ucBuilder, @RequestBody TeamUserDTO input) {
        teamUserService.deleteTeamUser(input.getIdUser(), input.getIdTeam());
    }
}
