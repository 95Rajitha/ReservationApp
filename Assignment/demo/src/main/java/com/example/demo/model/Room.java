package com.example.demo.model;

import com.example.demo.model.Entity.BookingEntity;
import com.example.demo.model.Entity.HotelEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room implements Serializable {

    private Integer roomId;
    private String type;
    private long priceRate;
    private int capacity;
    private boolean isAvailable;
    private List<BookingEntity> bookingEntities;
    private HotelEntity hotelEntity;

}
