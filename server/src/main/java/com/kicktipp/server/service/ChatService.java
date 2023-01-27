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

    public List<Nachicht> getPrivateChatMessages(Long userId, Long friendId) {
        return nachichten.findNachichtByChatId(getPrivateChat(userId, friendId).getId());
    }

    public Chat getPrivateChat(Long userId, Long friendId) {
        Chat c;
        c = chat.findChatByParty1IdAndAndParty2Id(userId, friendId);
        if (c != null) {
            return c;
        }
        c = chat.findChatByParty1IdAndAndParty2Id(friendId, userId);
        if (c != null) {
            return c;
        }
        c = new Chat();
        c.setParty1Id(userId);
        c.setParty2Id(friendId);
        chat.save(c);
        return chat.findChatByParty1IdAndAndParty2Id(userId, friendId);
    }

    public List<Nachicht> getTipprundeChatMessages(Long tipprundeId) {
        return nachichten.findNachichtByChatId(chat.findChatByTipprundeID(tipprundeId).id);
    }

    public Chat getTipprundeChat(Long tipprundeId) {
        Chat c = chat.findChatByTipprundeID(tipprundeId);
        if (c != null) {
            return c;
        }
        c = new Chat();
        c.setTipprundeID(tipprundeId);
        chat.save(c);
        return chat.findChatByTipprundeID(tipprundeId);
    }
    public Nachicht getLastMessageTime() {
        Nachicht n = nachichten.findTopByOrderByTimeDesc();
        n.setContent("");
        n.setBenutzerID(null);
        n.setId(null);
        return n;
    }

    public void sendMessage(Nachicht message) {
        message.setTime(System.currentTimeMillis());
        nachichten.save(message);
    }


    public List<Chat> getMyChats(Long userId) {
        return chat.findMyChats(userId);
    }
}
