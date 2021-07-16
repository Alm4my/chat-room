package fr.almamy.chatroom.controller;

import com.alibaba.fastjson.JSON;
import fr.almamy.chatroom.model.Message;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/chat")
public class WebSocketChatServer {
    /// === Fields ===
    /* All Chat Sessions */
    private static final Map<String, Session> onlineSessions = new ConcurrentHashMap<>();

    /// === Private Methods ===
    private static void sendMessageToAll(String msg){
        onlineSessions.forEach((id, session) ->{
            try {
                session.getBasicRemote().sendText(msg);
            } catch (IOException e){
                e.printStackTrace();
            }
        });
    }

    /// === Public Methods ===
    @OnOpen
    public void onOpen(Session session){
        onlineSessions.put(session.getId(), session);
        sendMessageToAll(Message.jsonStr("ENTER",
                "",
                "",
                onlineSessions.size()));
    }

    @OnMessage
    public void onMessage(Session session, String jsonStr){
        var message = (Message) JSON.parseObject(jsonStr, Message.class);
        sendMessageToAll(Message.jsonStr("SPEAK",
                message.getUsername(),
                message.getMsg(),
                onlineSessions.size()));

    }

    @OnClose
    public void onClose(Session session){
        onlineSessions.remove(session.getId());
        sendMessageToAll(Message.jsonStr("QUIT",
                "",
                "",
                onlineSessions.size()));
    }

    @OnError
    public void onError(Session session, Throwable error){
        error.printStackTrace();
    }
}
