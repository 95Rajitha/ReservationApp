package com.example.demo.model;

import com.example.demo.model.Entity.BookingEntity;
import com.example.demo.model.Entity.ContractEntity;
import com.example.demo.model.Entity.RoomEntity;
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
public class Hotel implements Serializable {

    private Integer hId;
    private String hotelName;
    private String ownerName;
    private List<BookingEntity> bookingEntities;
    private List<RoomEntity> roomEntities;
    private ContractEntity contractEntity;


}
