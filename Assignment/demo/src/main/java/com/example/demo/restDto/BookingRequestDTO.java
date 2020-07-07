package com.example.demo.restDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequestDTO {

    private Integer bookingId;
    private Date checkInDate;
    private Date checkOutDate;
    private int noOfRooms;
    private int noOfAdults;
    private int userId;
    private int guestId;
    private int hotelId;
    private List<Integer> roomIds;


}
