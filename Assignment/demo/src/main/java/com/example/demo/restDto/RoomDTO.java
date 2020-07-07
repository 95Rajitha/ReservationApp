package com.example.demo.restDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO implements Serializable {

    private Integer roomId;
    private String type;
    private long priceRate;
    private int capacity;
    private boolean isRoomAvailable;



}
