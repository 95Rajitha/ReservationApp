package com.example.demo.restDto;

import com.example.demo.model.Entity.HotelEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomRequestDTO {

    private Integer roomId;

    private String type;
    private long priceRate;
    private int capacity;
    private boolean isRoomAvailable;
    private int hotelId;

}
