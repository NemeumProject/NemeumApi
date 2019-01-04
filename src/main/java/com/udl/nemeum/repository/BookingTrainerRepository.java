package com.udl.nemeum.repository;

import com.udl.nemeum.models.BookingTrainerBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingTrainerRepository extends JpaRepository<BookingTrainerBO, Integer> {
    BookingTrainerBO findByidBookingTrainer(Integer id);
    List<BookingTrainerBO> findAll();
    void deleteById(Integer id);
    @Query("FROM BookingTrainerBO where id_user = :idUser")
    List<BookingTrainerBO> findBookingsByIdUser(Integer idUser);
}
