package com.udl.nemeum.repository;

import com.udl.nemeum.models.TrainerUserBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainerUserRepository extends JpaRepository<TrainerUserBO, Integer> {
    TrainerUserBO findByidTrainerUser(Integer id);
    TrainerUserBO findByusername(String id);
    TrainerUserBO findByemail(String id);
    void deleteById(Integer id);
    List<TrainerUserBO> findAll();
    @Query("SELECT DISTINCT usertrain FROM TrainerUserBO usertrain INNER JOIN TrainerSportBO trainersport ON (usertrain.idTrainerUser = trainersport.trainer)" +
            " INNER JOIN SportBO sport ON (trainersport.sportTrainer = sport.idSport)" +
            " WHERE sport.idSport = :id")
    List<TrainerUserBO> findTrainersBySport(Integer id);
}
