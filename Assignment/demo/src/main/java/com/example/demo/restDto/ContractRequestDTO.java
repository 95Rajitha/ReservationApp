package com.example.demo.restDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractRequestDTO {

    private Integer contractId;
    private Date startDate;
    private Date endDate;
    private int userID;
    private int hotelID;

}
