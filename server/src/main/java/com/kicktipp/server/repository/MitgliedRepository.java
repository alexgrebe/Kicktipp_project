package com.kicktipp.server.repository;

import com.kicktipp.server.model.Mitglied;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MitgliedRepository extends CrudRepository<Mitglied, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Mitglied m SET m.name = :name WHERE m.id = :mitgliedID")
    public void changeMitgliedName(@Param("name") String name, @Param("mitgliedID") Long mitgliedID);
}
