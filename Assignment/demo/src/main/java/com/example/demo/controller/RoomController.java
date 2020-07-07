package com.example.demo.controller;


import com.example.demo.model.Entity.RoomEntity;
import com.example.demo.restDto.RoomDTO;
import com.example.demo.restDto.RoomRequestDTO;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    /**
     * get all rooms
     * @return
     */
    @GetMapping("/rooms/{hotelId}")
    public List<RoomDTO> getRooms(@PathVariable int hotelId){

        return roomService.getRooms(hotelId);

    }

    /**
     * Add a room
     * @param roomRequestDTO
     *
     */
    @PostMapping("/rooms")
    public void addRoom(@RequestBody RoomRequestDTO roomRequestDTO){

        roomService.addRoom(roomRequestDTO);

    }


}
