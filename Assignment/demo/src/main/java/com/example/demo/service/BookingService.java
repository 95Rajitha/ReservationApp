package com.example.demo.service;

import com.example.demo.model.Entity.Dao.EntityDAO;
import com.example.demo.repository.*;
import com.example.demo.restDto.BookingDTO;
import com.example.demo.restDto.BookingDetailsDTO;
import com.example.demo.restDto.BookingRequestDTO;
import com.example.demo.service.transformers.BookingTransformation;
import com.example.demo.validation.BookingValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Qualifier("Booking")
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private BookingTransformation bookingTransformation;
    @Autowired
    private BookingValidation bookingValidation;
    @Autowired
    private EntityDAO entityDAO;

    /**
     * get all the booking list
     *
     * @return all booking list as boooking Entity
     */
    public List<BookingDTO> getAllBookings() {

        return entityDAO.getAllBookings();

    }


    /**
     * get booking list between two days
     *
     * @param checkInDate
     * @param checkOutDate
     * @return
     */
    public List<BookingDTO> getBookingList(Date checkInDate, Date checkOutDate) {

        return entityDAO.getBookingList(checkInDate, checkOutDate);

    }

    /**
     * get not booked list between two days
     *
     * @param checkInDate
     * @param checkOutDate
     * @return
     */

    public List<BookingDTO> getAllNotBookingList(Date checkInDate, Date checkOutDate) {

        return entityDAO.getAllNotBookingList(checkInDate, checkOutDate);

    }

    /**
     * get a booking by an ID
     *
     * @param bookingId
     * @return
     */
    public BookingDetailsDTO getBooking(Integer bookingId) {

        return entityDAO.getBooking(bookingId);


    }


    /**
     * update a booking
     *
     * @param bookingRequestDTO
     */
    public void updateBooking(BookingRequestDTO bookingRequestDTO) {

        entityDAO.updateBooking(bookingRequestDTO);

    }

    /**
     * delete a booking object
     *
     * @param bookingId
     * @return true if deleted succesfully
     */
    public boolean deleteBooking(int bookingId) {

        return entityDAO.deleteBooking(bookingId);

    }

    /**
     * add a booking in service layer after validating the inputs whether the parsed values are exists in the database
     *
     * @param bookingRequestDTO
     */
    public void addBooking(BookingRequestDTO bookingRequestDTO) {
        entityDAO.addBooking(bookingRequestDTO);
    }
}
