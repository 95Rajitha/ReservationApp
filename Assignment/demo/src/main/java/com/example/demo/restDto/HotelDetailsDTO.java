package com.example.demo.restDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDetailsDTO {

    private Integer hotelId;
    private String hotelName;
    private String ownerName;
    private List<HotelRoomDetailsDTO> hotelRoomDetailsDTOList;
}
