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

    public Long findIdByAuthtoken(String token);

    @Query("SELECT b FROM Benutzer b WHERE b.id IN (SELECT f1.sender FROM Freundschaftsanfragen f1 WHERE f1.sender = :id AND f1.bestatigt is true) " +
            "OR b.id IN (SELECT f2.empfanger FROM Freundschaftsanfragen f2 WHERE f2.empfanger = :id AND f2.bestatigt is true)")
    public List<Benutzer> getFreundeByID(@Param("id") Long id);

    @Query("SELECT b.email FROM Benutzer b WHERE b.id IN (SELECT f1.sender FROM Freundschaftsanfragen f1 WHERE f1.empfanger = :benutzerID AND f1.bestatigt is true)" +
            "OR b.id IN (SELECT f2.empfanger FROM Freundschaftsanfragen f2 WHERE f2.sender = :benutzerID AND f2.bestatigt is true)")
    public List<String> findFreundeEmailsById(@Param("benutzerID") Long benutzerID);
}
