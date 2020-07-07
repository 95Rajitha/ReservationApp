package com.example.demo.service.transformers;

import com.example.demo.model.Entity.HotelEntity;
import com.example.demo.restDto.ContractRequestDTONew;
import com.example.demo.restDto.HotelDTO;
import com.example.demo.restDto.HotelDetailsDTO;
import com.example.demo.restDto.HotelRoomDetailsDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HotelTransformation {


    public List<HotelDTO> convertToHotelDTO(List<HotelEntity> allHotelEntities) {

        List<HotelDTO> hotelDTOS = new ArrayList<>();
        allHotelEntities.forEach(hotelEntity -> {
            HotelDTO hotelDTO = new HotelDTO();
            hotelDTO.setHotelId(hotelEntity.getHotelId());
            hotelDTO.setHotelName(hotelEntity.getHotelName());
            hotelDTO.setOwnerName(hotelEntity.getOwnerName());
            hotelDTOS.add(hotelDTO);
        });

        return hotelDTOS;
    }

    public HotelDetailsDTO convertToHotelDetailsDTO(HotelEntity hotelEntity) {

        HotelDetailsDTO hotelDetailsDTO = new HotelDetailsDTO();
        hotelDetailsDTO.setOwnerName(hotelEntity.getOwnerName());
        hotelDetailsDTO.setHotelId(hotelEntity.getHotelId());
        hotelDetailsDTO.setHotelName(hotelEntity.getHotelName());
        hotelDetailsDTO.setHotelRoomDetailsDTOList(fetchHotelRoomDetails(hotelEntity));

        return hotelDetailsDTO;

    }

    private List<HotelRoomDetailsDTO> fetchHotelRoomDetails(HotelEntity hotelEntity) {

        List<HotelRoomDetailsDTO> hotelRoomDetailsDTOS = new ArrayList<>();
        hotelEntity.getRoomEntities().forEach(roomEntity -> {
            HotelRoomDetailsDTO hotelRoomDetailsDTO= new HotelRoomDetailsDTO();
            hotelRoomDetailsDTO.setRoomId(roomEntity.getRoomId());
            hotelRoomDetailsDTO.setPriceRate(roomEntity.getPriceRate());
            hotelRoomDetailsDTO.setType(roomEntity.getType());
            hotelRoomDetailsDTOS.add(hotelRoomDetailsDTO);
        });


        return hotelRoomDetailsDTOS;

    }

    public HotelEntity convertToHotelEntity1(ContractRequestDTONew contractRequestDTONew) {


        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setHotelId(contractRequestDTONew.getHotelID());
        hotelEntity.setHotelName(contractRequestDTONew.getHotelName());
        hotelEntity.setOwnerName(contractRequestDTONew.getOwnerName());
        return hotelEntity;



    }
}
