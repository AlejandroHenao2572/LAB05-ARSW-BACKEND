package com.board.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.board.model.DrawMessage;

@Controller
public class DrawnController {

    @MessageMapping("/draw") // This method will handle messages sent to the /app/draw destination
    @SendTo("/topic/draw") // Specify the destination to which the return value of the method will be sent. In this case, it sends the message to all subscribers of the /topic/draw topic.
    public DrawMessage handleDraw(DrawMessage message) {
        
        return message; // The message is returned and sent to all subscribers of /topic/draw
    }
}
