package com.example.RydeWebsocketServer.dtos;



import com.example.RydeWebsocketServer.controller.ExactLocation;
import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RydeRequestDto {

    private Long passengerId;

    private ExactLocation startLocation;

    private ExactLocation endLocation;

    private List<Long> driverId;
}
