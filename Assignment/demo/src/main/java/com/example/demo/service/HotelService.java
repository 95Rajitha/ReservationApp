package com.example.demo.service;

import com.example.demo.model.Entity.Dao.EntityDAO;
import com.example.demo.model.Entity.HotelEntity;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.RoomRepository;
import com.example.demo.restDto.HotelDTO;
import com.example.demo.restDto.HotelDetailsDTO;
import com.example.demo.service.transformers.HotelTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private HotelTransformation hotelTransformation;
    @Autowired
    private EntityDAO entityDAO;

    /**
     * get all hotels
     *
     * @return
     */
    public List<HotelDTO> getAllHotels() {

        return entityDAO.getAllHotels();


    }

    /**
     * get a hotel
     *
     * @param hotelId
     * @return
     */
    public HotelDetailsDTO getHotel(Integer hotelId) {

        return entityDAO.getHotel(hotelId);

    }

    /**
     * add a hotel
     *
     * @param hotelEntity
     */
    public void addHotel(HotelEntity hotelEntity) {

        entityDAO.addHotel(hotelEntity);

    }

    /**
     * update a hotel
     *
     * @param hotelEntity
     */
    public void updateHotel(HotelEntity hotelEntity) {
        entityDAO.updateHotel(hotelEntity);
    }

    /**
     * delete a hotel
     *
     * @param hotelId
     * @return true if deleted successfully
     */
    public boolean deleteHotel(int hotelId) {
        return entityDAO.deleteHotel(hotelId);
    }
}
