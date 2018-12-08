package com.udl.nemeum.repository;

import com.udl.nemeum.models.CompanyUserBO;
import com.udl.nemeum.models.IndividualUserBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IndividualUserRepository extends JpaRepository<IndividualUserBO, Integer> {
    IndividualUserBO findByidIndividualUser(Integer id);
    IndividualUserBO findByusername(String username);
    void deleteById(Integer id);
    List<IndividualUserBO> findAll();
    @Query("SELECT DISTINCT userind FROM IndividualUserBO userind INNER JOIN UserScenarioBO userscenario ON (userind.idIndividualUser = userscenario.userBO)" +
            " INNER JOIN ScenarioBO scenario ON (userscenario.scenarioBO = scenario.idScenario)" +
            " WHERE scenario.idScenario = :id")
    List<IndividualUserBO> findUsersByScenario(Integer id);
    @Query("SELECT DISTINCT userind FROM IndividualUserBO userind INNER JOIN TeamUserBO teamuser ON (userind.idIndividualUser = teamuser.user)" +
            " INNER JOIN TeamBO team ON (teamuser.team = team.idTeam)" +
            " WHERE team.idTeam = :id")
    List<IndividualUserBO> findUsersByTeam(Integer id);
    @Query("SELECT DISTINCT userind FROM IndividualUserBO userind INNER JOIN UserSportBO usersport ON (userind.idIndividualUser = usersport.userLevel)" +
            " INNER JOIN SportBO sport ON (usersport.sportLevel = sport.idSport)" +
            " WHERE sport.idSport = :id")
    List<IndividualUserBO> findUsersBySport(Integer id);

}
