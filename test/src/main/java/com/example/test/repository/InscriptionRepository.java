package com.example.test.repository;

import com.example.test.model.Inscription;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InscriptionRepository extends BaseRepository<Inscription, Long> {
    Optional<Inscription> findById(Long id);
}
