package com.kicktipp.server.repository;

import com.kicktipp.server.model.Tipp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TippRepository extends CrudRepository<Tipp, Long> {

    @Query("SELECT t FROM Tipp t WHERE t.mitgliedID = :mitgliedID")
    public List<Tipp> findMyTipps(@Param("mitgliedID") Long mitgliedID);

    @Query("SELECT t FROM Tipp t WHERE t.spielID = :gameID AND t.mitgliedID = :mitgliedID")
    public List<Tipp> findMyTippsByGame(@Param("mitgliedID") Long mitgliedID, @Param("gameID") Long gameID);
}
