package com.example.demo.service.transformers;

import com.example.demo.model.Entity.*;
import com.example.demo.repository.GuestRepository;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.restDto.BookingDTO;
import com.example.demo.restDto.BookingDetailsDTO;
import com.example.demo.restDto.BookingRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class BookingTransformation {


    @Autowired
    private GuestRepository guestRepository; // if these post calls work remove the autoWired parts in the bookingService

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    /**
     * get booking list
     * @param allBookingEntities
     * @return
     */
    public List<BookingDTO> getAllBookingDTOs(List<BookingEntity> allBookingEntities) {

        List<BookingDTO> bookingDTOList = new ArrayList<>();
         allBookingEntities.forEach(bookingEntity -> {
             BookingDTO bookingDTO = new BookingDTO();

             bookingDTO.setNoOfAdults(bookingEntity.getNoOfAdults());
             bookingDTO.setNoOfRooms(bookingEntity.getNoOfRooms());
         bookingDTO.setBookingId(bookingEntity.getBookingId());
         bookingDTO.setCheckInDate(convertDateToString(bookingEntity.getCheckInDate()));
         bookingDTO.setCheckOutDate(convertDateToString(bookingEntity.getCheckOutDate()));
         bookingDTO.setHotelName(getHotelName(bookingEntity.getHotelEntity()));
         bookingDTOList.add(bookingDTO);});
         return bookingDTOList;

    }

    public String convertDateToString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return formatter.format(date);



    }

    /**
     * get the hotel name
     * @param hotelEntity
     * @return
     */
    private String getHotelName(HotelEntity hotelEntity) {

        return hotelEntity.getHotelName();

    }

    /**
     * booking degails are sent
     * @param bookingEntity
     * @return
     */
    public BookingDetailsDTO getBookingDetailsDTO(BookingEntity bookingEntity) {

        BookingDetailsDTO bookingDetailsDTO = new BookingDetailsDTO();
        bookingDetailsDTO.setBookingId(bookingEntity.getBookingId());
        bookingDetailsDTO.setCheckInDate(bookingEntity.getCheckInDate());
        bookingDetailsDTO.setCheckOutDate(bookingEntity.getCheckOutDate());
        bookingDetailsDTO.setNoOfAdults(bookingEntity.getNoOfAdults());
        bookingDetailsDTO.setGuestName(bookingEntity.getGuestEntity().getGuestName());
        bookingDetailsDTO.setUserName(bookingEntity.getUserEntity().getUserName());
        bookingDetailsDTO.setRoomIdList(getRoomIds(bookingEntity.getRoomEntities()));

        return bookingDetailsDTO;
    }


    /**
     * room Ids are fetched and set to the booking details
     * @param roomEntities
     * @return
     */
    private List<Integer> getRoomIds(List<RoomEntity> roomEntities) {

        List<Integer> roomIdList = new ArrayList<>();
        roomEntities.forEach(roomEntity ->
            roomIdList.add(roomEntity.getRoomId())
        );

        return roomIdList;
    }

    /**
     * converting a DTO to an entity
     * @param bookingRequestDTO
     * @return
     */
    public BookingEntity convertToBookingEntity(BookingRequestDTO bookingRequestDTO) {

        BookingEntity bookingEntity = new BookingEntity();

        bookingEntity.setBookingId(bookingRequestDTO.getBookingId());
        bookingEntity.setCheckInDate(bookingRequestDTO.getCheckInDate());
        bookingEntity.setCheckOutDate(bookingRequestDTO.getCheckOutDate());
        bookingEntity.setNoOfAdults(bookingRequestDTO.getNoOfAdults());
        bookingEntity.setNoOfRooms(bookingRequestDTO.getNoOfRooms());
        bookingEntity.setGuestEntity(fetchGuestEntity(bookingRequestDTO.getGuestId()));
        bookingEntity.setHotelEntity(fetchHotelEntity(bookingRequestDTO.getHotelId()));
        bookingEntity.setUserEntity(fetchUserEntity(bookingRequestDTO.getUserId()));
        bookingEntity.setRoomEntities(fetchRoomEntities(bookingRequestDTO.getRoomIds()));
        return bookingEntity;
    }

    /**
     * fetch the room entities from the parsed IDs and set the avaialability of the rooms as false
     * @param roomIds
     * @return
     */
    private List<RoomEntity> fetchRoomEntities(List<Integer> roomIds) {

        List<RoomEntity> roomEntityList = new ArrayList<>();

        for (Integer roomId : roomIds) {
            RoomEntity roomEntity=roomRepository.findById(roomId).get();
            roomEntity.setRoomAvailable(false);
            roomEntityList.add(roomEntity);
            roomEntityList.add(roomEntity);
        }

        return roomEntityList;


    }

    /**
     * fetch the user entities
     * @param userId
     * @return
     */
    private UserEntity fetchUserEntity(int userId) {
        return userRepository.findById(userId).get();
    }

    /**
     * fetch the Hotel entities
     * @param hotelId
     * @return
     */
    private HotelEntity fetchHotelEntity(int hotelId) {
        return hotelRepository.findById(hotelId).get();
    }

    /**
     * fetch the guest entities
     * @param guestId
     * @return
     */
    private GuestEntity fetchGuestEntity(int guestId) {
            return guestRepository.findById(guestId).get();
    }
}
