package com.udl.nemeum.repository;

import com.udl.nemeum.models.CompanyUserBO;
import com.udl.nemeum.models.ScenarioBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyUserRepository extends JpaRepository<CompanyUserBO, Integer>,CompanyUserRepositoryCustom {
    CompanyUserBO findByidCompanyUser(Integer id);
}
