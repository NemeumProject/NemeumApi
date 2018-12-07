package com.udl.nemeum.controller;

import com.udl.nemeum.dto.EventDTO;
import com.udl.nemeum.services.EventService;
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
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<EventDTO>> getAllEvents() throws IOException {
        List<EventDTO> events = eventService.getAllEvents();
        return new ResponseEntity<List<EventDTO>>(events, HttpStatus.OK);
    }

    @RequestMapping(value = "/{idEvent}", method = RequestMethod.DELETE)
    @Transactional
    public void deleteEvent(@PathVariable("idEvent") Integer id) {
        eventService.deleteEvent(id);
    }

    @RequestMapping(value = "/{idEvent}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public EventDTO getEvent(@PathVariable("idEvent") Integer id){
        return eventService.getEvent(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
    public EventDTO add(UriComponentsBuilder ucBuilder, @RequestBody EventDTO input) {

        return eventService.addEvent(input);

    }

    @RequestMapping(method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE})
    public EventDTO modify(UriComponentsBuilder ucBuilder, @RequestBody EventDTO input) {

        return eventService.modifyEvent(input);

    }
}
