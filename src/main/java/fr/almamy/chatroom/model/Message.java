package fr.almamy.chatroom.model;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class Message {
    /// === Constants ===
    @Getter public static final String ENTER = "ENTER";
    @Getter public static final String SPEAK = "SPEAK";
    @Getter public static final String QUIT = "QUIT";

    /// === Fields ===
    private String type;
    private String username;
    private String msg;
    private int onlineCount;

    /// === Public Methods ===
    public static String jsonStr(String type, String username, String msg, int onlineTotal) {
        return JSON.toJSONString(new Message(type, username, msg, onlineTotal));
    }
}