package fr.almamy.chatroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatController {
    @RequestMapping("/")
    public String login(){
        return "login";
    }
    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/chat")
    public String chat(@RequestParam String username, Model model){
        model.addAttribute("username", username);
        return "chat";
    }
}
