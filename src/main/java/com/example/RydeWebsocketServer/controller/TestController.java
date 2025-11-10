package com.example.RydeWebsocketServer.controller;


import com.example.RydeWebsocketServer.dtos.TestRequest;
import com.example.RydeWebsocketServer.dtos.TestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

//    @Autowired
    private SimpMessagingTemplate messageSender;

    public TestController(SimpMessagingTemplate messageSender){
        this.messageSender = messageSender;
    }

    @MessageMapping("/ping")
    @SendTo("/topic/ping")
    public TestResponse pingCheck(TestRequest message){

        return new TestResponse("Received");
    }

//    @SendTo("/topic/sheduled")
////    @Scheduled(fixedDelay = 2000)
//    public void periodicMsg(TestRequest message){
//        messageSender.convertAndSend("/topic/sheduled" , "periodic message sent " + System.currentTimeMillis());
//    }


}
