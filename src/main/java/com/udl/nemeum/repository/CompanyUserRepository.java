package com.udl.nemeum.repository;

import com.udl.nemeum.models.CompanyUserBO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyUserRepository extends JpaRepository<CompanyUserBO, Integer> {
    CompanyUserBO findByidCompanyUser(Integer id);
    List<CompanyUserBO> findAll();
    void deleteById(Integer id);
}
