package com.kicktipp.server.repository;

import com.kicktipp.server.model.Benutzer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Benutzer, Long> {
    public Benutzer findByEmail(String email);

    @Transactional
    @Modifying
    @Query("update Benutzer b set b.authtoken = :token where b.id = :identifiyer")
    public void updateAuth_token(@Param("token") String token, @Param("identifiyer") Long id);

    public Benutzer findByAuthtoken(String auth_token);

    public Benutzer findByEmailAndPasswort(String email, String passwort);

    public boolean existsBenutzerByAuthtoken(String token);

    public String findRoleByAuthtoken(String token);

    @Query("SELECT b.id FROM Benutzer b WHERE b.authtoken = :token")
    public Long findIdByAuthtoken(@Param("token") String token);

    @Query("SELECT b FROM Benutzer b WHERE b.id IN (SELECT f1.empfanger FROM Freundschaftsanfragen f1 WHERE f1.sender = :id AND f1.bestatigt is true) " +
            "OR b.id IN (SELECT f2.sender FROM Freundschaftsanfragen f2 WHERE f2.empfanger = :id AND f2.bestatigt is true)")
    public List<Benutzer> getFreundeByID(@Param("id") Long id);

    @Query("SELECT b.email FROM Benutzer b WHERE b.id IN (SELECT f1.sender FROM Freundschaftsanfragen f1 WHERE f1.empfanger = :benutzerID AND f1.bestatigt is true)" +
            "OR b.id IN (SELECT f2.empfanger FROM Freundschaftsanfragen f2 WHERE f2.sender = :benutzerID AND f2.bestatigt is true)")
    public List<String> findFreundeEmailsById(@Param("benutzerID") Long benutzerID);

    @Query("SELECT b FROM Benutzer b WHERE b.id IN (SELECT f1.sender FROM Freundschaftsanfragen f1 WHERE f1.empfanger = :id AND f1.bestatigt is false)")
    public List<Benutzer> findOffeneFreunde(@Param("id") Long id);

    @Query("SELECT b FROM Benutzer b WHERE (b.id NOT IN (SELECT f1.sender FROM Freundschaftsanfragen f1 WHERE f1.empfanger = :id)" +
            "AND b.id NOT IN (SELECT f2.empfanger FROM Freundschaftsanfragen f2 WHERE f2.sender = :id)) AND b.id != :id")
    public List<Benutzer> findNutzerOhneFreund(@Param("id") Long id);

    @Query("SELECT b FROM Benutzer b WHERE b.id NOT IN (SELECT m.benutzerID FROM Mitglied m WHERE m.tipprundeID = :id)")
    public List<Benutzer> findNutzerNotInTipprunde(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Benutzer b SET b.wetterlaubnis = true WHERE b.id = :id")
    public void erlaubnisErteilen(@Param("id") Long id);

    @Query("SELECT b FROM Benutzer b WHERE b.role = 'admin'")
    public List<Benutzer> findAdmins();

    @Transactional
    @Modifying
    @Query("UPDATE Benutzer b SET b.wetterlaubnis = :antwort WHERE b.id = :benutzerID")
    public void updateErlaubnis(@Param("antwort")boolean antwort, @Param("benutzerID")Long benutzerID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE benutzer b SET b.geld = :wert + b.geld WHERE b.id = :benutzerID", nativeQuery = true)
    public void updateGeld(@Param("benutzerID")Long benutzerID, @Param("wert")double wert);
}
