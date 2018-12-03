package com.udl.nemeum.repository;

import com.udl.nemeum.models.UserSportBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserSportRepository extends JpaRepository<UserSportBO, Integer> {
    UserSportBO findByidUserSport(Integer id);
    List<UserSportBO> findAll();
    void deleteById(Integer id);
    @Query("FROM UserSportBO where id_user = :user and id_sport = :sport")
    UserSportBO findUserSportBySport(Integer user, Integer sport);
}
