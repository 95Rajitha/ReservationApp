package com.example.demo.model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Contract")
public class ContractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractId; //  Change in controller/Service
@Temporal(TemporalType.DATE)
    private Date startDate;
@Temporal(TemporalType.DATE)
    private Date endDate;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "us_id")
    @JsonIgnore
    private UserEntity userEntity;

    @OneToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    private HotelEntity hotelEntity;


}
