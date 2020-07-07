package com.example.demo.model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Booking")
public class BookingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;     //should change in the controller/Service

    @Temporal(TemporalType.DATE)
    private Date checkInDate;     //should change in the controller/Service
    @Temporal(TemporalType.DATE)
    private Date checkOutDate;    //should change in the controller/Service
    private int noOfRooms;
    private int noOfAdults;




    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "guest_id")
    @JsonIgnore
    private GuestEntity guestEntity;

    @ManyToOne(fetch = FetchType.LAZY,optional = false )
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    private HotelEntity hotelEntity;

    @ManyToMany
    @JsonIgnore
    private List<RoomEntity> roomEntities;




}
