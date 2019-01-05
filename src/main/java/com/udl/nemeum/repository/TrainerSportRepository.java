package com.udl.nemeum.repository;

import com.udl.nemeum.models.TrainerSportBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainerSportRepository extends JpaRepository<TrainerSportBO, Integer> {
    TrainerSportBO findByidTrainingServicePost(Integer id);
    List<TrainerSportBO> findAll();
    void deleteById(Integer id);
    @Query("FROM TrainerSportBO where id_trainer_user = :trainer and id_sport = :sport")
    TrainerSportBO findTrainerSport(Integer trainer, Integer sport);
}
