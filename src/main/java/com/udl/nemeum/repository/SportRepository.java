package com.udl.nemeum.repository;

import com.udl.nemeum.models.CompanyUserBO;
import com.udl.nemeum.models.SportBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<SportBO, Integer>,CompanyUserRepositoryCustom{
    SportBO findByidSport(Integer id);
}
