package com.kicktipp.server.repository;

import com.kicktipp.server.model.Benutzer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Benutzer, Long> {
    public Benutzer findByEmail(String email);

    @Modifying
    @Query("update Benutzer b set b.authtoken = ?1 where b.id = ?2")
    public void updateAuth_token(String token, Long id);

    public Benutzer findByAuthtoken(String auth_token);
}
