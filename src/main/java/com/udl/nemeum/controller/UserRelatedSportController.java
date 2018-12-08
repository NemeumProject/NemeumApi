package com.udl.nemeum.controller;

import com.udl.nemeum.dto.UserSportDTO;
import com.udl.nemeum.services.UserSportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/userSport")
public class UserRelatedSportController {

    @Autowired
    private UserSportService userSportService;

    @RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
    public UserSportDTO add(UriComponentsBuilder ucBuilder, @RequestBody UserSportDTO input) {

        return userSportService.add(input);

    }

    @RequestMapping(method = RequestMethod.DELETE)
    @Transactional
    public void deleteUserSport(UriComponentsBuilder ucBuilder, @RequestBody UserSportDTO input) {
        userSportService.deleteUserSport(input.getIdUser(), input.getIdSport());
    }
}
