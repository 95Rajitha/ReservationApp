package com.example.demo.validation;

import com.example.demo.model.Entity.RoomEntity;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.restDto.BookingRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingValidation {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RoomRepository roomRepository;

    /**
     * doing the validation to check whether the parsed entities are found or not
      * @param bookingRequestDTO
     * @return
     */
    public boolean entityValidation(BookingRequestDTO bookingRequestDTO) {

        boolean isGuestExists = bookingRepository.findById(bookingRequestDTO.getGuestId()).isPresent();
        boolean isUserExists = bookingRepository.findById(bookingRequestDTO.getUserId()).isPresent();
        boolean isHotelExists = bookingRepository.findById(bookingRequestDTO.getHotelId()).isPresent();
        boolean areRoomsExist = checkRoomsExist(bookingRequestDTO.getRoomIds());

        return isGuestExists && isUserExists && isHotelExists && areRoomsExist;

    }


    /**
     * check the rooms wether exists or not
     * @param roomIds
     * @return
     */
    private boolean checkRoomsExist(List<Integer> roomIds) {

        for (Integer roomId : roomIds) {
            if(!roomRepository.findById(roomId).isPresent()){
                throw new  RuntimeException("room ID "+roomId+" not exists");
            }
            RoomEntity roomEntity=roomRepository.findById(roomId).get();
            roomEntity.setRoomAvailable(false);
        }
       return true;
    }
}
