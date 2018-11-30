package com.udl.nemeum.repository;

import com.udl.nemeum.models.CompanyUserBO;
import com.udl.nemeum.models.IndividualUserBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualUserRepository extends JpaRepository<IndividualUserBO, Integer> {
    IndividualUserBO findByidIndividualUser(Integer id);
    void deleteById(Integer id);
}
