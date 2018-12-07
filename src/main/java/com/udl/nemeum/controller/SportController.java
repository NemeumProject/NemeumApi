package com.udl.nemeum.controller;

import com.udl.nemeum.dto.SportDTO;
import com.udl.nemeum.services.SportService;
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
@RequestMapping("/sport")
public class SportController {

    @Autowired
    private SportService sportService;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<SportDTO>> getAllSports() throws IOException {
        List<SportDTO> sports = sportService.getAllSports();
        return new ResponseEntity<List<SportDTO>>(sports, HttpStatus.OK);
    }

    @RequestMapping(value = "/{idSport}", method = RequestMethod.DELETE)
    @Transactional
    public void deleteSport(@PathVariable("idSport") Integer id) {
        sportService.deleteSport(id);
    }

    @RequestMapping(value = "/{idSport}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public SportDTO getSport(@PathVariable("idSport") Integer id){
        return sportService.getSport(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
    public SportDTO add(UriComponentsBuilder ucBuilder, @RequestBody SportDTO input) {

        return sportService.addSport(input);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE})
    public SportDTO modify(UriComponentsBuilder ucBuilder, @RequestBody SportDTO input) {

        return sportService.modifySport(input);
    }
}
