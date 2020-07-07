package com.example.demo.restDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContractRequestDTONew {


    // no use of this classs remove it

    private Integer contractId;
    private Date startDate;
    private Date endDate;
    private int userID;
    private int hotelID;
    private String hotelName;
    private String ownerName;


}
