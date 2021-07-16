package fr.almamy.chatroom.config;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/chat")
public class WebSocketConfig {
    /// === Fields ===
    /* All Chat Sessions */
    private Map<String, Session> onlineSessions = new ConcurrentHashMap<>();

    /// === Private Methods ===
    private static void sendMessageToAll(String msg){

    }

    /// === Public Methods ===
    @OnOpen
    public void onOpen(Session session){

    }

    @OnMessage
    public void onMessage(Session session, String jsonStr){

    }

    @OnClose
    public void onClose(Session session){

    }

    @OnError
    public void onError(Session session, Throwable error){

    }
}
