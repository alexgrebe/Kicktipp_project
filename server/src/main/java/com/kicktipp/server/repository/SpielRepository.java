package com.kicktipp.server.repository;

import com.kicktipp.server.model.Liga;
import com.kicktipp.server.model.Spiel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface SpielRepository extends CrudRepository<Spiel, Long> {
    public List<Spiel> findAllByDatum(Date datum);

    public List<Spiel> findAllByLiga(Liga liga);

    @Transactional
    @Modifying
    @Query("update Spiel s set s.heimtore = :ht, s.auswaertstore = :at where s.id = :identifiyer")
    public void updateTore(@Param("ht") Integer heimtore, @Param("at") Integer auswaertstore, @Param("identifiyer") Long id);
}
