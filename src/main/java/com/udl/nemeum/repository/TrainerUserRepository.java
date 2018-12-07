package com.udl.nemeum.repository;

import com.udl.nemeum.models.TrainerUserBO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainerUserRepository extends JpaRepository<TrainerUserBO, Integer> {
    TrainerUserBO findByidTrainerUser(Integer id);
    void deleteById(Integer id);
    List<TrainerUserBO> findAll();
}
