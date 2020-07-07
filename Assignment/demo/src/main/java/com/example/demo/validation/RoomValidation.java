package com.example.demo.validation;

import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.restDto.RoomDTO;
import com.example.demo.restDto.RoomRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomValidation {

    @Autowired
    private HotelRepository hotelRepository;

    public boolean validateEntity(RoomRequestDTO roomRequestDTO) {

        return hotelRepository.findById(roomRequestDTO.getHotelId()).isPresent();

    }
}
