package com.udl.nemeum.repository;

import com.udl.nemeum.models.EventBO;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EventRepository extends PagingAndSortingRepository<EventBO, Integer> {

    EventBO findByidEvent(Integer id);
    List<EventBO> findAll();
    void deleteById(Integer id);
}
