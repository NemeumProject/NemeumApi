package com.udl.nemeum.repository;

import com.udl.nemeum.models.SportBO;
import com.udl.nemeum.models.TrainerSportBO;
import com.udl.nemeum.models.TrainerUserBO;

import java.util.List;

public interface TrainerSportRepositoryCustom {
    List<TrainerSportBO> filter(String trainer, String city, Double price, Integer sport);
    List<TrainerSportBO> findServices(Integer idUser);
}
