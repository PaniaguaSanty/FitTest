package com.example.test.repository;

import com.example.test.model.Nutritionist;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionistRepository extends BaseRepository<Nutritionist, Long> {
    Nutritionist findByDni(String dni);
}
