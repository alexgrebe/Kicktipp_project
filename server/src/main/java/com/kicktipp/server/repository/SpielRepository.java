package com.kicktipp.server.repository;

import com.kicktipp.server.model.Spiel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface SpielRepository extends CrudRepository<Spiel, Long> {
    public List<Spiel> findAllByDatum(Date datum);

    public List<Spiel> findAllByLigaFremdschlussel(Long schlussel);

    @Transactional
    @Modifying
    @Query("update Spiel s set s.heimtore = :ht, s.auswaertstore = :at where s.id = :identifiyer")
    public void updateTore(@Param("ht") Integer heimtore, @Param("at") Integer auswaertstore, @Param("identifiyer") Long id);

    @Query("SELECT s FROM Spiel s WHERE s.ligaFremdschlussel = (SELECT t1.ligaID FROM Tipprunde t1 WHERE t1.id = :id) AND s.datum >= :date AND s.id NOT IN (SELECT t.spielID FROM Tipp t WHERE t.mitgliedID = :mitgliedID)")
    public List<Spiel> findSpieleByDatumAndLiga(@Param("date")LocalDate date, @Param("id") Long id, @Param("mitgliedID")Long mitgliedID);

    @Query(value = "SELECT * FROM spiel s WHERE s.datum < :date AND (s.heimteam = :name OR s.auswaertsteam = :name) ORDER BY datum DESC LIMIT 3", nativeQuery = true)
    public List<Spiel> findLastThreeSpieleByTeamName(@Param("date")LocalDate date, @Param("name") String name);

    @Query(value = "SELECT * FROM spiel s WHERE s.datum > (SELECT d.sys_time FROM configuration d LIMIT 1) " +
            "AND s.liga_fremdschlussel = :ligaID", nativeQuery = true)
    public List<Spiel> findAllGamesPlayedInALeagueBeforeDate(@Param("ligaID") Long ligaID);

    @Query(value = "SELECT * FROM spiel s WHERE s.liga_fremdschlussel IN (SELECT s1.liga_fremdschlussel FROM spiel s1 WHERE s1.id = :spielID)" +
            "AND s.datum < (SELECT d.sys_time FROM configuration d LIMIT 1)", nativeQuery = true)
    public List<Spiel> findGamesInLeagueBySpielIDBeforeSysTime(@Param("spielID")Long spielID);

    @Query(value = "SELECT * FROM spiel s WHERE s.heimteam = (SELECT s1.heimteam FROM spiel s1 WHERE s1.id = :spielID LIMIT 1) " +
            "AND s.datum = (SELECT d.sys_time FROM configuration d LIMIT 1) ORDER BY s.datum DESC LIMIT 5", nativeQuery = true)
    public List<Spiel> findLast5GamesHome(@Param("spielID")Long spielID);

    @Query(value = "SELECT * FROM spiel s WHERE s.auswaertsteam = (SELECT s1.auswaertsteam FROM spiel s1 WHERE s1.id = :spielID LIMIT 1) " +
            "AND s.datum = (SELECT d.sys_time FROM configuration d LIMIT 1) ORDER BY s.datum DESC LIMIT 5", nativeQuery = true)
    public List<Spiel> findLast5GamesAus(@Param("spielID")Long spielID);
}
