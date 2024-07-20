package com.example.test.repository;

import com.example.test.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends BaseRepository<Client, Long> {
    Client findByDni(String dni);
}
