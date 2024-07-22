package com.example.test.repository;

import com.example.test.model.Gym;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository extends BaseRepository<Gym, Long> {
}
