package com.kicktipp.server.repository;

import com.kicktipp.server.model.Liga;
import com.kicktipp.server.model.Spiel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface LigaRepository extends CrudRepository<Liga, Long> {
    public Liga findByName(String name);

    @Transactional
    @Modifying
    @Query("update Liga l set l.logoID = :logoID where l.id = :identifiyer")
    public void updateLogoID(@Param("logoID") Long logoID, @Param("identifiyer") Long id);

    public Optional<Liga> findById(Long Id);

}
