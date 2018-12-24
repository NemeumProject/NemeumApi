package com.udl.nemeum.repository;

import com.udl.nemeum.models.ScenarioBO;
import com.udl.nemeum.models.SportBO;

import java.util.List;

public interface ScenarioRepositoryCustom{

    List<ScenarioBO> findScenarioByFilter(SportBO sport, Double price, String city);
}
