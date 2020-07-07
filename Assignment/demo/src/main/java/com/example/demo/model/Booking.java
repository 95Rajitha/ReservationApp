package com.example.demo.model;

import com.example.demo.model.Entity.GuestEntity;
import com.example.demo.model.Entity.HotelEntity;
import com.example.demo.model.Entity.RoomEntity;
import com.example.demo.model.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Booking implements Serializable {

    private Integer bId;
    private Date startDate;
    private Date endDate;
    private int noOfRooms;
    private int noOfAdults;
    private GuestEntity guestEntity;
    private UserEntity userEntity;
    private HotelEntity hotelEntity;
    private List<RoomEntity> roomEntities;


}
