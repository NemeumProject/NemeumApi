package com.udl.nemeum.repository;

import com.udl.nemeum.models.CompanyUserBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyUserRepository extends JpaRepository<CompanyUserBO, Integer> {
    CompanyUserBO findByidCompanyUser(Integer id);
}
