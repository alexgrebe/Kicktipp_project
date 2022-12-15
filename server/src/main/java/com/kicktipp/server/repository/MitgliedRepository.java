package com.kicktipp.server.repository;

import com.kicktipp.server.model.Mitglied;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MitgliedRepository extends CrudRepository<Mitglied, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Mitglied m SET m.name = :name WHERE m.id = :mitgliedID")
    public void changeMitgliedName(@Param("name") String name, @Param("mitgliedID") Long mitgliedID);

    @Query("SELECT m FROM Mitglied m WHERE m.tipprundeID = :tipprundenID")
    public List<Mitglied> getMitgliedByTipprundenID(@Param("tipprundenID") Long tipprundenID);

    @Query("SELECT m.benutzerID FROM Mitglied m WHERE m.id = :id")
    public Long findBenutzerIDById(@Param("id") Long id);

    @Query("SELECT m FROM Mitglied m WHERE m.benutzerID = :benutzerID AND m.tipprundeID = :tipprundenID")
    public Mitglied findMitgliedByTipprundenIDAndBenutzerID(@Param("benutzerID") Long benutzerID, @Param("tipprundenID") Long tipprundenID);
}
