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
public class SingleGuestDetailsDTO implements Serializable {


    private Integer guestId;
    private String guestName;
    private String contact;
    private List<Integer> bookingsIds;
    private List<Date> checkInDateList;
    private List<Date> checkOutDateList;
    private List<String> hotelList;


}
