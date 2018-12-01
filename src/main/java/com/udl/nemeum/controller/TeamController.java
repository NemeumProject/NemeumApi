package com.udl.nemeum.controller;

import com.udl.nemeum.dto.TeamDTO;
import com.udl.nemeum.services.TeamService;
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
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TeamDTO>> getAllTeams() throws IOException {
        List<TeamDTO> teams = teamService.getAllTeams();
        return new ResponseEntity<List<TeamDTO>>(teams, HttpStatus.OK);
    }

    @RequestMapping(value = "/{idTeam}", method = RequestMethod.DELETE)
    @Transactional
    public void deleteTeam(@PathVariable("idTeam") Integer id) {
        teamService.deleteTeam(id);
    }

    @RequestMapping(value = "/{idTeam}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public TeamDTO getTeam(@PathVariable("idTeam") Integer id){
        return teamService.getTeam(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
    public TeamDTO add(UriComponentsBuilder ucBuilder, @RequestBody TeamDTO input) {

        return teamService.addTeam(input);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE})
    public TeamDTO modify(UriComponentsBuilder ucBuilder, @RequestBody TeamDTO input) {

        return teamService.modifyTeam(input);
    }
}
