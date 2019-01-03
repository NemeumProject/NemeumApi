package com.udl.nemeum.controller;

import com.udl.nemeum.dto.BookingTrainerDTO;
import com.udl.nemeum.services.BookingTrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/joinTrainer")
public class BookingTrainerController {

    @Autowired
    private BookingTrainerService bookingTrainerService;

    @RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
    public BookingTrainerDTO add(UriComponentsBuilder ucBuilder, @RequestBody BookingTrainerDTO input) {

        return bookingTrainerService.add(input);

    }
}
