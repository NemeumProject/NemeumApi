package com.udl.nemeum.repository;

import com.udl.nemeum.models.TeamBO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<TeamBO, Integer> {
    TeamBO findByidTeam(Integer id);
    List<TeamBO> findAll();
    void deleteById(Integer id);
}
