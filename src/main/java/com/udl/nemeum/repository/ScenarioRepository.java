package com.udl.nemeum.repository;

import com.udl.nemeum.dto.FilterScenarioDTO;
import com.udl.nemeum.models.ScenarioBO;
import com.udl.nemeum.models.SportBO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ScenarioRepository extends PagingAndSortingRepository<ScenarioBO, Integer> {
    ScenarioBO findByidScenario(Integer id);
    List<ScenarioBO> findAll();
    void deleteById(Integer id);

}
