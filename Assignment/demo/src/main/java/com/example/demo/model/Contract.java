package com.example.demo.model;

import com.example.demo.model.Entity.HotelEntity;
import com.example.demo.model.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contract implements Serializable {

    private Integer conId;
    private Date startDate;
    private Date endDate;
    private UserEntity userEntity;
    private HotelEntity hotelEntity;


}
