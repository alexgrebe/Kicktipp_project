package com.kicktipp.server.controller;

import com.kicktipp.server.model.Chat;
import com.kicktipp.server.model.Liga;
import com.kicktipp.server.model.Nachicht;
import com.kicktipp.server.model.Spiel;
import com.kicktipp.server.service.AuthService;
import com.kicktipp.server.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:80", "http://localhost"}, allowCredentials = "true")
public class ChatController {
    @Autowired
    ChatService service;

    @Autowired
    AuthService authService;

    @GetMapping("/getPrivateChat/{id}")
    public ResponseEntity<Chat> getPrivateChat(@PathVariable Long id, @CookieValue(value = "auth_token", required = false) String token) {
        try {
            if (token == null || !authService.verifyToken(token))
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            return new ResponseEntity<>(service.getPrivateChat(authService.findIdByAuthtoken(token), id), HttpStatus.ACCEPTED);
        }
        catch(Exception e) {return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);}
    }

    @GetMapping("/getTipprundeChat/{id}")
    public ResponseEntity<Chat> getTipprundeChat(@PathVariable Long id, @CookieValue(value = "auth_token", required = false) String token) {
        try {
            if (token == null || !authService.verifyToken(token))
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            return new ResponseEntity<>(service.getTipprundeChat(id), HttpStatus.ACCEPTED);
        }
        catch(Exception e) {return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);}
    }


    @GetMapping("/getPrivateChatMessages/{id}")
    public ResponseEntity<List<Nachicht>> getPrivateChatMessages(@PathVariable Long id, @CookieValue(value = "auth_token", required = false) String token) {
        try {
            if (token == null || !authService.verifyToken(token))
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            return new ResponseEntity<>(service.getPrivateChatMessages(authService.findIdByAuthtoken(token), id), HttpStatus.ACCEPTED);
        }
        catch(Exception e) {return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);}
    }

    @GetMapping("/getTipprundeChatMessages/{id}")
    public ResponseEntity<List<Nachicht>> getTipprundeChatMessages(@PathVariable Long id, @CookieValue(value = "auth_token", required = false) String token) {
        try {
            if (token == null || !authService.verifyToken(token))
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            return new ResponseEntity<>(service.getTipprundeChatMessages(id), HttpStatus.ACCEPTED);
        }
        catch(Exception e) {return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);}
    }

    @GetMapping("/getLastMessageTime")
    public ResponseEntity<Nachicht> getLastMessageTime(@CookieValue(value = "auth_token", required = false) String token) {
        try {
            if (token == null || !authService.verifyToken(token))
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            return new ResponseEntity<>(service.getLastMessageTime(), HttpStatus.ACCEPTED);
        }
        catch(Exception e) {return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);}
    }

    @PostMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestBody Nachicht message, @CookieValue(value = "auth_token", required = false) String token) {
        try{
            if (token == null || !authService.verifyToken(token))
                return new ResponseEntity<>("Failed!", HttpStatus.UNAUTHORIZED);
            message.setBenutzerID(authService.findIdByAuthtoken(token));
            service.sendMessage(message);
            return new ResponseEntity<>("", HttpStatus.ACCEPTED);}
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
