package com.udl.nemeum.repository;

import com.udl.nemeum.models.SportBO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SportRepository extends JpaRepository<SportBO, Integer> {
    SportBO findByidSport(Integer id);
    List<SportBO> findAll();
    void deleteById(Integer id);
}
