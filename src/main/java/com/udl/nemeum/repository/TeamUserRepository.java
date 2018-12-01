package com.udl.nemeum.repository;

import com.udl.nemeum.models.TeamUserBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamUserRepository extends JpaRepository<TeamUserBO, Integer> {
    TeamUserBO findByidTeamUser(Integer id);
    List<TeamUserBO> findAll();
    void deleteById(Integer id);
    @Query("FROM TeamUserBO where id_team = :team and id_user = :user")
    TeamUserBO finTeamUserByTeamUser(Integer user, Integer team);
}
