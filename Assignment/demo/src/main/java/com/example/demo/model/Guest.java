package com.example.demo.model;

import com.example.demo.model.Entity.BookingEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Guest implements Serializable {

    private Integer gId;
    private String gName;
    private String contact;
    private List<BookingEntity> bookingEntities;




}
