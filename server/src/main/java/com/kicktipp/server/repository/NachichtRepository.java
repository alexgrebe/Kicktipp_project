package com.kicktipp.server.repository;

import com.kicktipp.server.model.Nachicht;
import com.kicktipp.server.model.Tipp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NachichtRepository extends CrudRepository<Nachicht, Long> {
    public Nachicht findNachichtById(Long id);
    public List<Nachicht> findNachichtByChatId(Long id);
    public Nachicht findTopByOrderByTimeDesc();

//    @Query("SELECT n FROM Nachicht n WHERE n.ChatId = :ID  ")
//    public List<Nachicht> findNachichtByChatId50(@Param("ID") Long ID);
}
