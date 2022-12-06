package com.kicktipp.server.repository;

import com.kicktipp.server.model.Mitglied;
import org.springframework.data.repository.CrudRepository;

public interface MitgliedRepository extends CrudRepository<Mitglied, Long> {
}
