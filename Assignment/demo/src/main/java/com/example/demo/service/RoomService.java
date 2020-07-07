package com.example.demo.service;

import com.example.demo.model.Entity.Dao.EntityDAO;
import com.example.demo.model.Entity.RoomEntity;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.restDto.RoomDTO;
import com.example.demo.restDto.RoomRequestDTO;
import com.example.demo.service.transformers.RoomTransformation;
import com.example.demo.validation.RoomValidation;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomTransformation roomTransformation;

    @Autowired
    private RoomValidation roomValidation;

    @Autowired
    private EntityDAO entityDAO;

    /**
     * add a room to a particular hotel
     * @param roomRequestDTO
     * @param
     */
    public void addRoom(RoomRequestDTO roomRequestDTO) {

        entityDAO.addRoom(roomRequestDTO);


    }

    /**
     * get  all rooms
     * @return
     * @param hotelId
     */
    public List<RoomDTO> getRooms(int hotelId) {

        return entityDAO.getRooms(hotelId);


    }
}
