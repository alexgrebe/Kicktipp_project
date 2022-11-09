package com.kicktipp.server.repository;

import com.kicktipp.server.model.Configuration;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ConfigRepository extends CrudRepository<Configuration, Long> {
    public Configuration findByAttribute(String attribute);

    @Transactional
    @Modifying
    @Query("update Configuration c set c.value = :value where c.attribute = :attribute")
    public void updateConfig_Value(@Param("attribute") String attribute, @Param("value") String value);
}
