package com.udl.nemeum.services;

import com.udl.nemeum.dto.EventDTO;
import com.udl.nemeum.models.EventBO;
import com.udl.nemeum.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("eventService")
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private IndividualUserRepository individualUserRepository;

    @Autowired
    private CompanyUserRepository companyUserRepository;

    @Autowired
    private TrainerUserRepository trainerUserRepository;

    @Autowired
    private SportRepository sportRepository;

    public List<EventDTO> getAllEvents(){
        List<EventBO> scenarioBOS = eventRepository.findAll();
        return toDTO(scenarioBOS);
    }

    public EventDTO getEvent(Integer id){
        return new EventDTO(eventRepository.findByidEvent(id));
    }

    public void deleteEvent(Integer id){

        eventRepository.deleteById(id);
    }

    public EventDTO addEvent(EventDTO input) {
        EventBO event = toBO(input);
        EventBO resultEvent = eventRepository.save(event);

        return new EventDTO(resultEvent);
    }

    private EventBO toBO(EventDTO dto){
        EventBO bo = new EventBO();

        if(dto.getIdCompanyUser() != null){
            bo.setCompanyUser(companyUserRepository.findByidCompanyUser(dto.getIdCompanyUser()));
        }

        bo.setSport(sportRepository.findByidSport(dto.getIdSport()));
        bo.setAddress(dto.getAddress());
        bo.setCapacity(dto.getCapacity());
        bo.setCity(dto.getCity());
        bo.setDateEvent(dto.getDateEvent());
        bo.setDescription(dto.getDescription());
        bo.setIndoor(dto.getIndoor());
        bo.setPhone(dto.getPhone());
        bo.setPostalCode(dto.getPostalCode());
        bo.setPrice(dto.getPrice());

        return bo;
    }

    private List<EventDTO> toDTO(List<EventBO> eventBOList){
        List<EventDTO> eventDTOList = new ArrayList<>();
        for(EventBO eventBO : eventBOList ){
            eventDTOList.add(new EventDTO(eventBO));
        }
        return eventDTOList;
    }

    public EventDTO modifyEvent(EventDTO input) {
        EventBO event = toBO(input);
        event.setIdEvent(input.getIdEvent());
        EventBO resultEvent = eventRepository.save(event);

        return new EventDTO(resultEvent);
    }
}
