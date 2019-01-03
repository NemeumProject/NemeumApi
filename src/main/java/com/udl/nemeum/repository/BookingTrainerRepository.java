package com.udl.nemeum.repository;

import com.udl.nemeum.models.BookingTrainerBO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingTrainerRepository extends JpaRepository<BookingTrainerBO, Integer> {
    BookingTrainerBO findByidBookingTrainer(Integer id);
    List<BookingTrainerBO> findAll();
    void deleteById(Integer id);
}
