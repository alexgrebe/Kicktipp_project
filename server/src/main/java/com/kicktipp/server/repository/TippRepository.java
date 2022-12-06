package com.kicktipp.server.repository;

import com.kicktipp.server.model.Tipp;
import org.springframework.data.repository.CrudRepository;

public interface TippRepository extends CrudRepository<Tipp, Long> {
}
