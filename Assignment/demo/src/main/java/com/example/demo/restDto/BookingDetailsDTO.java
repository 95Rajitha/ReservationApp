package com.example.demo.restDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDetailsDTO implements Serializable {

    private Integer bookingId;
    private Date checkInDate;
    private Date checkOutDate;
    private int noOfAdults;
    private String hotelName;
    private List<Integer> roomIdList;
    private String userName;
    private String guestName;

}
