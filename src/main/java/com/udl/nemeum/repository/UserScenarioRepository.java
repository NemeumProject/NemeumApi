package com.udl.nemeum.repository;

import com.udl.nemeum.models.IndividualUserBO;
import com.udl.nemeum.models.UserScenarioBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserScenarioRepository extends JpaRepository<UserScenarioBO, Integer> {
    UserScenarioBO findByuserScenario(Integer id);
    List<UserScenarioBO> findAll();
    void deleteById(Integer id);
    @Query("FROM UserScenarioBO where id_scenario = :scenario and id_user = :user")
    UserScenarioBO findUserScenarioByScenario(Integer user, Integer scenario);
}
