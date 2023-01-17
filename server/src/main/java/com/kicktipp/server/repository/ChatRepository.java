package com.kicktipp.server.repository;

import com.kicktipp.server.model.Chat;
import com.kicktipp.server.model.Freundschaftsanfragen;
import com.kicktipp.server.model.Tipprunde;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends CrudRepository<Chat, Long> {
    public Chat findChatById(Long id);
    public Chat findChatByTipprundeID(Long TipprundeId);

    @Query("SELECT c FROM Chat c WHERE c.party1Id = :id OR c.party2Id = :id")
    public List<Chat> findMyChats(@Param("id") Long id);
}
