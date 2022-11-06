package com.kicktipp.server.repository;

import com.kicktipp.server.model.Benutzer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Benutzer, Long> {
    public Benutzer findByEmail(String email);
}
