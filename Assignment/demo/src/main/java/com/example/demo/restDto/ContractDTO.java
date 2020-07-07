package com.example.demo.restDto;

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
public class ContractDTO implements Serializable {

    private Integer contractId;
    private Date startDate;
    private Date endDate;
    private String userName;
    private int userId;
    private  int hotelId;
    private String hotelName;

}
