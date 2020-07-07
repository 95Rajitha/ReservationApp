package com.example.demo.restDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelRoomDetailsDTO {

    private Integer roomId;
    private String type;
    private long priceRate;

}
