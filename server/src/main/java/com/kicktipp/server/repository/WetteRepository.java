package com.kicktipp.server.repository;

import com.kicktipp.server.model.Wette;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WetteRepository extends CrudRepository<Wette, Long> {
}
