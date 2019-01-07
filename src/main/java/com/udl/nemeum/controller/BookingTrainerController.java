package com.udl.nemeum.controller;

import com.udl.nemeum.dto.BookingTrainerDTO;
import com.udl.nemeum.services.BookingTrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/joinTrainer")
public class BookingTrainerController {

    @Autowired
    private BookingTrainerService bookingTrainerService;

    @RequestMapping(value = "/{idUser}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<BookingTrainerDTO>> getBookings(@PathVariable("idUser") Integer id) {
        List<BookingTrainerDTO> bookings = bookingTrainerService.findByIdUser(id);
        return new ResponseEntity<List<BookingTrainerDTO>>(bookings, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
    public BookingTrainerDTO add(UriComponentsBuilder ucBuilder, @RequestBody BookingTrainerDTO input) {

        return bookingTrainerService.add(input);

    }

    @RequestMapping(value = "/{idBookingTrainer}", method = RequestMethod.DELETE)
    @Transactional
    public void deleteBooking(@PathVariable("idBookingTrainer") Integer id) {
        bookingTrainerService.deleteBookingService(id);
    }
}
