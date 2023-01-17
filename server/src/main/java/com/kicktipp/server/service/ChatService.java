package com.kicktipp.server.service;

import com.kicktipp.server.model.Chat;
import com.kicktipp.server.model.Liga;
import com.kicktipp.server.model.Nachicht;
import com.kicktipp.server.repository.ChatRepository;
import com.kicktipp.server.repository.NachichtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {
    @Autowired
    ChatRepository chat;

    @Autowired
    NachichtRepository nachichten;

    public List<Nachicht> getPrivateChatMessages(Long userId) {
        List<Nachicht> o = new ArrayList<>();
        for (Chat c : chat.findMyChats(userId)) {
            o.addAll(nachichten.findNachichtByChatId(c.id));
        }
        return o;
    }

    public List<Nachicht> getTipprundeChatMessages(Long tipprundeId) {
        return nachichten.findNachichtByChatId(chat.findChatByTipprundeID(tipprundeId).id);
    }
}
