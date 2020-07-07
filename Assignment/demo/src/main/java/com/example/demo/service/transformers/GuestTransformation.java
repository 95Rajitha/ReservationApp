package com.example.demo.service.transformers;

import com.example.demo.model.Entity.BookingEntity;
import com.example.demo.model.Entity.GuestEntity;
import com.example.demo.restDto.BookingDTO;
import com.example.demo.restDto.GuestDTO;
import com.example.demo.restDto.SingleGuestDTO;
import com.example.demo.restDto.SingleGuestDetailsDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class GuestTransformation {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BookingTransformation bookingTransformation;

    /**
     * guest Entity convert to guestDTO type
     *
     * @param guestEntity
     * @return
     */
    public GuestDTO convertToDto(GuestEntity guestEntity) {

        return modelMapper.map(guestEntity, GuestDTO.class);

    }

    public GuestEntity convertToEntity(GuestDTO guestDto) {

        return modelMapper.map(guestDto, GuestEntity.class);

    }

    /**
     * guest object is converted to a singleDTO object
     *
     * @param guestEntity
     * @return
     */
    public SingleGuestDTO convertToSingleGuestDTO(GuestEntity guestEntity) {

        SingleGuestDTO singleGuestDTO = new SingleGuestDTO();

        singleGuestDTO.setGuestId(guestEntity.getGuestId());
        singleGuestDTO.setGuestName(guestEntity.getGuestName());
        singleGuestDTO.setContact(guestEntity.getGuestContactNo());
        singleGuestDTO.setBookings(setToBookingDto(guestEntity.getBookingEntities()));
        return singleGuestDTO;

    }

    /**
     * convert to bookingDTO
     *
     * @param bookingObjList
     * @return
     */
    public List<BookingDTO> setToBookingDto(List<BookingEntity> bookingObjList) {

        List<BookingDTO> bookingDTOS = new ArrayList<>();

        BookingDTO bookingDTO = new BookingDTO();
        for (int i = 0; i < bookingObjList.size(); i++) {

            BookingEntity booking = bookingObjList.get(i);
            bookingDTO.setBookingId(booking.getBookingId());
            bookingDTO.setCheckOutDate(bookingTransformation.convertDateToString(booking.getCheckInDate()));
            bookingDTO.setCheckInDate(bookingTransformation.convertDateToString(booking.getCheckOutDate()));
            bookingDTO.setNoOfAdults(booking.getNoOfAdults());
            bookingDTO.setNoOfRooms(booking.getNoOfRooms());
            bookingDTOS.add(i, bookingDTO);
        }

        return bookingDTOS;

    }

    /**
     * convert a single guest details into a DTO
     *
     * @param guestEntity
     * @return
     */
    public SingleGuestDetailsDTO convertToSingleGuestFilterDTO(GuestEntity guestEntity) {

        SingleGuestDetailsDTO singleGuestDetailsDTO = new SingleGuestDetailsDTO();
        singleGuestDetailsDTO.setBookingsIds(setBookingIds(guestEntity.getBookingEntities()));
        singleGuestDetailsDTO.setGuestId(guestEntity.getGuestId());
        singleGuestDetailsDTO.setGuestName(guestEntity.getGuestName());
        singleGuestDetailsDTO.setContact(guestEntity.getGuestContactNo());
        singleGuestDetailsDTO.setHotelList(setHotelNames(guestEntity.getBookingEntities()));
        singleGuestDetailsDTO.setCheckInDateList(setCheckInDates(guestEntity.getBookingEntities()));
        singleGuestDetailsDTO.setCheckOutDateList(setCheckOutDates(guestEntity.getBookingEntities()));
        return singleGuestDetailsDTO;
    }

    /**
     * getting the check in date List of booking
     *
     * @param bookingEntities
     * @return
     */
    private List<Date> setCheckInDates(List<BookingEntity> bookingEntities) {

        List<Date> checkInDateList = new ArrayList<>();
        int i = 0;
        for (BookingEntity booking : bookingEntities) {

            checkInDateList.add(i++, booking.getCheckInDate());

        }
        return checkInDateList;
    }

    /**
     * getting the check out date List of booking
     *
     * @param bookingEntities
     * @return
     */
    private List<Date> setCheckOutDates(List<BookingEntity> bookingEntities) {

        List<Date> checkOutDateList = new ArrayList<>();
        int i = 0;
        for (BookingEntity booking : bookingEntities) {

            checkOutDateList.add(i++, booking.getCheckOutDate());

        }
        return checkOutDateList;
    }

    /**
     * get all the hotels related to bookings
     *
     * @param bookingEntities
     * @return
     */
    private List<String> setHotelNames(List<BookingEntity> bookingEntities) {

        List<String> hotelNames = new ArrayList<>();
        int i = 0;
        for (BookingEntity booking : bookingEntities) {

            hotelNames.add(i++, booking.getHotelEntity().getHotelName());

        }

        return hotelNames;
    }

    /**
     * get all the the bookings of the guest
     *
     * @param bookingEntities
     * @return
     */
    private List<Integer> setBookingIds(List<BookingEntity> bookingEntities) {

        List<Integer> bookingIdList = new ArrayList<>();
        int i = 0;
        for (BookingEntity booking : bookingEntities) {

            bookingIdList.add(i++, booking.getBookingId());

        }

        return bookingIdList;
    }

    /**
     * get list of Guest DTOs
     * @param allGuestEntityList
     * @return
     */
    public List<GuestDTO> convertToGuestDTO(List<GuestEntity> allGuestEntityList) {

        List<GuestDTO> guestDTOList = new ArrayList<>();

        allGuestEntityList.forEach(guestEntity -> {
            GuestDTO guestDTO = new GuestDTO();
            guestDTO.setBookingList(guestEntity.getBookingEntities());
            guestDTO.setGuestId(guestEntity.getGuestId());
            guestDTO.setContact(guestEntity.getGuestContactNo());
            guestDTO.setGuestName(guestEntity.getGuestName());
            guestDTOList.add(guestDTO);

        });

        return guestDTOList;
    }

    /**
     * get a guestEntity
     * @param guestDTO
     * @return
     */
    public GuestEntity convertToGuestEntity(GuestDTO guestDTO) {

        GuestEntity guestEntity = new GuestEntity();
        guestEntity.setGuestId(guestDTO.getGuestId());
        guestEntity.setGuestName(guestDTO.getGuestName());
        guestEntity.setGuestContactNo(guestDTO.getContact());
        return guestEntity;

    }
}
