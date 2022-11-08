package com.kicktipp.server.repository;

import com.kicktipp.server.model.Benutzer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends CrudRepository<Benutzer, Long> {
    public Benutzer findByEmail(String email);

    @Transactional
    @Modifying
    @Query("update Benutzer b set b.authtoken = :token where b.id = :identifiyer")
    public void updateAuth_token(@Param("token") String token, @Param("identifiyer") Long id);

    public Benutzer findByAuthtoken(String auth_token);

    public Benutzer findByEmailAndPasswort(String email, String passwort);
}
