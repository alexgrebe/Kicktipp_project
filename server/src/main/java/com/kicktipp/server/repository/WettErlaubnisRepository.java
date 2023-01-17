package com.kicktipp.server.repository;

import com.kicktipp.server.model.Wetterlaubnis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WettErlaubnisRepository extends CrudRepository<Wetterlaubnis, Long> {
    public Wetterlaubnis findWetterlaubnisByBenutzerID(Long id);
}
