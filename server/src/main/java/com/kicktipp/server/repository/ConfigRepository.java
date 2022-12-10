package com.kicktipp.server.repository;

import com.kicktipp.server.model.Configuration;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Repository
public interface ConfigRepository extends CrudRepository<Configuration, Long> {

    @Transactional
    @Modifying
    @Query("update Configuration c set c.sysTime = :value where c.id = :id")
    public void updateSysTime(@Param("id") Long id, @Param("value") LocalDate value);
}
