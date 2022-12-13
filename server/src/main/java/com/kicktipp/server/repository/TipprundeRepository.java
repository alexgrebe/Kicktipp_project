package com.kicktipp.server.repository;

import com.kicktipp.server.model.Tipp;
import com.kicktipp.server.model.Tipprunde;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TipprundeRepository extends CrudRepository<Tipprunde, Long> {
    @Query("SELECT t FROM Tipprunde t WHERE ((t.privat is false OR t.besitzerID IN (SELECT f2.empfanger FROM Freundschaftsanfragen f2 WHERE f2.sender= :benutzerID AND f2.bestatigt is true) " +
            "OR t.besitzerID IN (SELECT f1.sender FROM Freundschaftsanfragen f1 WHERE f1.empfanger= :benutzerID AND f1.bestatigt is true)) AND " +
            "(t.id NOT IN (SELECT m.tipprundeID FROM Mitglied m WHERE benutzerID = :benutzerID)))" )
    public List<Tipprunde> findTipprunde(@Param("benutzerID") Long benutzerID);

    @Query("SELECT t FROM Tipprunde t WHERE t.id IN (SELECT m.tipprundeID FROM Mitglied m WHERE m.benutzerID = :benutzerID)")
    public List<Tipprunde> findMyTipprunde(@Param("benutzerID") Long benutzerID);

    public Tipprunde findTipprundeById(Long id);

    @Query("SELECT t FROM Tipprunde t WHERE t.besitzerID = :id")
    public List<Tipprunde> findTipprundeByBesitzerid(@Param("id") Long id);
}
