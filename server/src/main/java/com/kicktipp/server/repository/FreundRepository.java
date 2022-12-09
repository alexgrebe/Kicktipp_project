package com.kicktipp.server.repository;

import com.kicktipp.server.model.Freundschaftsanfragen;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FreundRepository extends CrudRepository<Freundschaftsanfragen, Long> {

    @Query("SELECT f FROM Freundschaftsanfragen f WHERE f.empfanger = :id AND bestatigt is false")
    public List<Freundschaftsanfragen> findOffeneFreundschaftsanfragen(@Param("id") Long id);

    @Query("DELETE FROM Freundschaftsanfragen f WHERE " +
            "(f.sender = : benutzerID AND f.empfanger = :freundID) OR (f.sender = :freundID AND f.empfanger = :benutzerID)")
    public void deleteFreund(@Param("freundID") Long freundID, @Param("benutzerID") Long benutzerID);
}
