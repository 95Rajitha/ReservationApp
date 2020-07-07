package com.example.demo.restDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO implements Serializable {

    private Integer bookingId;
    private String checkInDate;
    private String checkOutDate;
    private int noOfRooms;
    private int noOfAdults;
    private String hotelName;

}
