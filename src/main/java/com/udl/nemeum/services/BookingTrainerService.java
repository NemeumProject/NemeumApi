package com.udl.nemeum.services;

import com.udl.nemeum.dto.BookingTrainerDTO;
import com.udl.nemeum.models.BookingTrainerBO;
import com.udl.nemeum.repository.BookingTrainerRepository;
import com.udl.nemeum.repository.IndividualUserRepository;
import com.udl.nemeum.repository.TrainerSportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("bookingTrainerService")
public class BookingTrainerService {

    @Autowired
    private IndividualUserRepository individualUserRepository;

    @Autowired
    private TrainerSportRepository trainerSportRepository;

    @Autowired
    private BookingTrainerRepository bookingTrainerRepository;

    public BookingTrainerDTO add(BookingTrainerDTO dto){
        BookingTrainerBO bo = new BookingTrainerBO();
        bo.setIdUser(individualUserRepository.findByidIndividualUser(dto.getIdUser()));
        bo.setIdService(trainerSportRepository.findByidTrainingServicePost(dto.getIdService()));
        bo.setDateBooking(dto.getDateBooking());
        bo.setEndBooking(dto.getEndBooking());
        bo.setStartBooking(dto.getStartBooking());
        bo.setPrice(dto.getPrice());

        BookingTrainerBO finalBo = bookingTrainerRepository.save(bo);

        return new BookingTrainerDTO(finalBo);
    }


    public List<BookingTrainerDTO> findByIdUser(Integer idUser){
        List<BookingTrainerBO> bookingTrainerBOList = bookingTrainerRepository.findBookingsByIdUser(idUser);
        return toDTO(bookingTrainerBOList);
    }

    public List<BookingTrainerDTO> toDTO(List<BookingTrainerBO> bookingTrainerBOList){
        List<BookingTrainerDTO> bookingTrainerDTOList = new ArrayList<>();

        for(BookingTrainerBO bo : bookingTrainerBOList){
            bookingTrainerDTOList.add(new BookingTrainerDTO(bo));
        }

        return bookingTrainerDTOList;
    }

    public void deleteBookingService(Integer idBookingTrainer) {
        if(idBookingTrainer != null){
            bookingTrainerRepository.deleteById(idBookingTrainer);
        }
    }
}
