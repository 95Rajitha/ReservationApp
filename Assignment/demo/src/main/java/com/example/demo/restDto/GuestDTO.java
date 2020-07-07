package com.example.demo.restDto;

import com.example.demo.model.Entity.BookingEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GuestDTO implements Serializable {


    private Integer guestId;
    private String guestName;
    private String contact;
    private List<BookingEntity> bookingList;



}
