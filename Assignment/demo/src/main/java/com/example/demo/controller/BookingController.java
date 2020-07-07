package com.example.demo.controller;


import com.example.demo.model.Entity.BookingEntity;
import com.example.demo.restDto.BookingDTO;
import com.example.demo.restDto.BookingDetailsDTO;
import com.example.demo.restDto.BookingRequestDTO;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    /**
     * getting all the booking list
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/bookings")
    public List<BookingDTO> getAllbookings() {
        return bookingService.getAllBookings();
    }

    /**
     * get bookings between two days
     *
     * @param checkInDate
     * @param checkOutDate
     * @return
     */
    @GetMapping("/bookings/filter")
    public List<BookingDTO> getBookingList(@RequestParam("s") @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkInDate, @RequestParam("e") @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkOutDate) {

        if (checkInDate != null && checkOutDate != null) {
            return bookingService.getBookingList(checkInDate, checkOutDate);
        } else {
            throw new RuntimeException("checkInDate/checkOutDate params have not set");
        }
    }

    /**
     * get all bookings that are nit between two days
     * http://localhost:8081/bookings/notfilter?s=2013-08-10&e=2013-08-20 >>> Req URL
     *
     * @param checkInDate
     * @param checkOutDate
     * @return
     */
    @GetMapping("/bookings/notfilter")
    public List<BookingDTO> getAllNotBookingList(@RequestParam("s") @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkInDate, @RequestParam("e") @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkOutDate) {
        return bookingService.getAllNotBookingList(checkInDate, checkOutDate);
    }

    /**
     * get a booking by ID
     *
     * @param bookingId
     * @return
     */
    @GetMapping("/bookings/{bookingId}")
    public BookingDetailsDTO getBooking(@PathVariable Integer bookingId) {

//        BookingDetailsDTO bookingDetailsDTO = bookingService.getBooking(bookingId);
//
//        if (bookingDetailsDTO == null)
//
//            return (bookingDetailsDTO,HttpStatus.OK);
        return bookingService.getBooking(bookingId);
    }

    /**
     * add a booking
     *
     * @param bookingRequestDTO
     */
    @RequestMapping(method = RequestMethod.POST, value = "/bookings")
    public void addBooking(@RequestBody BookingRequestDTO bookingRequestDTO) {

        if(bookingRequestDTO == null){
            throw new RuntimeException("there is no object to save");
        }

        bookingService.addBooking(bookingRequestDTO);
    }

    /**
     * update a booking
     *
     * @param bookingRequestDTO
     */
    //Problem occured
    @PutMapping("/bookings")
    public void updateBooking(@RequestBody BookingRequestDTO bookingRequestDTO) {

        bookingService.updateBooking(bookingRequestDTO);

    }

    /**
     * delete a bookig object
     *
     * @param bookingId
     * @return
     */
    @DeleteMapping("/bookings/{bookingId}")
    public boolean deleteBooking(@PathVariable int bookingId) {

        return !bookingService.deleteBooking(bookingId);

    }


}
