package com.example.test.repository;

import com.example.test.model.Trainer;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends BaseRepository<Trainer, Long> {
}
