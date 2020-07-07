package com.example.demo.controller;

import com.example.demo.model.Entity.HotelEntity;
import com.example.demo.restDto.HotelDTO;
import com.example.demo.restDto.HotelDetailsDTO;
import com.example.demo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    private HotelService hotelService;

    /**
     * get hotel list
     * @return
     */
    @GetMapping("/hotel")
    public List<HotelDTO> getAllHotel(){
        return hotelService.getAllHotels();
    }

    /**
     * get a hotel
     * @param hotelId
     * @return
     */
    @GetMapping("/hotel/{hotelId}")
    public HotelDetailsDTO getHotel(@PathVariable Integer hotelId){

        return hotelService.getHotel(hotelId);
    }

    /**
     * add a hotel
     * @param hotelEntity
     */
    @PostMapping("/hotel")
    public void addHotel(@RequestBody HotelEntity hotelEntity){

        hotelService.addHotel(hotelEntity);
    }

    /**
     * update a hotel
     * @param hotelEntity
     */
    @PutMapping("/hotel")
    public void updateHotel(@RequestBody HotelEntity hotelEntity){
        hotelService.updateHotel(hotelEntity);
    }

    /**
     * delete a hotel
     * @param hotelId
     * @return
     */
    @DeleteMapping("/hotel/{hotelId}")
    public boolean deleteHotel(@PathVariable int hotelId){
        return hotelService.deleteHotel(hotelId);
    }

}
