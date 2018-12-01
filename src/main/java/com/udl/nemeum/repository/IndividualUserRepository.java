package com.udl.nemeum.repository;

import com.udl.nemeum.models.CompanyUserBO;
import com.udl.nemeum.models.IndividualUserBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IndividualUserRepository extends JpaRepository<IndividualUserBO, Integer> {
    IndividualUserBO findByidIndividualUser(Integer id);
    void deleteById(Integer id);
    @Query("SELECT DISTINCT userind FROM IndividualUserBO userind INNER JOIN UserScenarioBO userscenario ON (userind.idIndividualUser = userscenario.userBO)" +
            " INNER JOIN ScenarioBO scenario ON (userscenario.scenarioBO = scenario.idScenario)" +
            " WHERE scenario.idScenario = :id")
    List<IndividualUserBO> findUsersByScenario(Integer id);
}
