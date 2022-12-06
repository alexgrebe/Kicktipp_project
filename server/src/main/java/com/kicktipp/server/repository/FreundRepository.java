package com.kicktipp.server.repository;

import com.kicktipp.server.model.Freundschaftsanfragen;
import org.springframework.data.repository.CrudRepository;

public interface FreundRepository extends CrudRepository<Freundschaftsanfragen, Long> {

}
