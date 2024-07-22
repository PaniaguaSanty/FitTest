package com.example.test.repository;

import com.example.test.model.GymManager;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends BaseRepository<GymManager, Long> {
    Optional<GymManager> findByDni(String dni);
}
