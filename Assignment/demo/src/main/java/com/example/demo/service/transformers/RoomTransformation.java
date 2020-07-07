package com.example.demo.service.transformers;

import com.example.demo.model.Entity.HotelEntity;
import com.example.demo.model.Entity.RoomEntity;
import com.example.demo.repository.HotelRepository;
import com.example.demo.restDto.RoomDTO;
import com.example.demo.restDto.RoomRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomTransformation {


    @Autowired
    private HotelRepository hotelRepository;
    public List<RoomDTO> convertToRoomDTO(List<RoomEntity> allRoomEntities) {

        List<RoomDTO> roomEntityList = new ArrayList<>();

        allRoomEntities.forEach(roomEntityObj -> {
            RoomDTO roomDTO = new RoomDTO();
            roomDTO.setRoomId(roomEntityObj.getRoomId());
            roomDTO.setCapacity(roomEntityObj.getCapacity());
            roomDTO.setPriceRate(roomEntityObj.getPriceRate());
            roomDTO.setType(roomEntityObj.getType());
            roomDTO.setRoomAvailable(roomEntityObj.isRoomAvailable());
            roomEntityList.add(roomDTO);
        });

        return roomEntityList;
    }

    public RoomEntity convertToRoomEntity(RoomRequestDTO roomRequestDTO) {

        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setRoomAvailable(true);
        roomEntity.setCapacity(roomRequestDTO.getCapacity());
        roomEntity.setHotelEntity(fetchHotel(roomRequestDTO.getHotelId()));
        roomEntity.setRoomId(roomRequestDTO.getRoomId());
        roomEntity.setType(roomRequestDTO.getType());
        roomEntity.setPriceRate(roomRequestDTO.getPriceRate());
        return roomEntity;

    }

    private HotelEntity fetchHotel(int hotelId) {

       return hotelRepository.findById(hotelId).get();

    }
}
