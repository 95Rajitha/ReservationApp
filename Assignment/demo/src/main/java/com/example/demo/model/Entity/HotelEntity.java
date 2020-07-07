package com.example.demo.model.Entity;

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
@Table(name = "Hotel")
public class HotelEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelId;    // controller/Service changes

    private String hotelName;
    private String ownerName;


    @OneToMany(mappedBy = "hotelEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookingEntity> bookingEntities;

    @OneToMany(mappedBy = "hotelEntity", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<RoomEntity> roomEntities;

    @OneToOne(mappedBy = "hotelEntity",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private ContractEntity contractEntity;

  }
