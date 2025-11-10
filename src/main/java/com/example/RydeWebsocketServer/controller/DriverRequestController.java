package com.example.RydeWebsocketServer.controller;

import com.example.RydeWebsocketServer.dtos.RideResponseDto;
import com.example.RydeWebsocketServer.dtos.RydeRequestDto;
import com.example.RydeWebsocketServer.dtos.TestRequest;
import com.example.RydeWebsocketServer.dtos.TestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/socket")
public class DriverRequestController {


    private final SimpMessagingTemplate simpMessagingTemplate;


    public DriverRequestController(SimpMessagingTemplate simpMessagingTemplate){
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @PostMapping("/newride")
    @CrossOrigin(originPatterns = "*")
    public ResponseEntity<Boolean> raiseRideRequest(@RequestBody RydeRequestDto rydeRequestDto){
        sendDriversNewRideRequest(rydeRequestDto);

        return new ResponseEntity<>(Boolean.TRUE , HttpStatus.OK);

    }

    public void sendDriversNewRideRequest(RydeRequestDto rydeRequestDto){

        simpMessagingTemplate.convertAndSend("/topic/rideRequest" , rydeRequestDto);
    }

    @MessageMapping("/rideResponse")
    public void rideResponseHandler(RideResponseDto rideResponseDto){

        System.out.println(rideResponseDto.getResponse());

    }

}
