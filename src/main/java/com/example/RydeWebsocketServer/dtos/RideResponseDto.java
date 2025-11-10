package com.example.RydeWebsocketServer.dtos;

import lombok.*;

@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RideResponseDto {

    public boolean response;

    public boolean getResponse() {

        return response;
    }
}
