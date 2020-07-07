package com.example.demo.model.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Room")
public class RoomEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;

    private String type;
    private long priceRate;
    private int capacity;
    private boolean isRoomAvailable; // newly added controller and Service check



    @ManyToMany
    private List<BookingEntity> bookingEntities;

    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "ho_Id")
    @JsonIgnore
    private HotelEntity hotelEntity;

    }
