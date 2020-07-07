package com.example.demo.service;

import com.example.demo.model.Entity.Dao.EntityDAO;
import com.example.demo.model.Entity.GuestEntity;
import com.example.demo.model.Guest;
import com.example.demo.repository.GuestRepository;
import com.example.demo.restDto.GuestDTO;
import com.example.demo.restDto.SingleGuestDTO;
import com.example.demo.restDto.SingleGuestDetailsDTO;
import com.example.demo.service.transformers.GuestTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private GuestTransformation guestTransformation;

    @Autowired
    private EntityDAO entityDAO;

    /**
     * get all the guests
     *
     * @return
     */
    public List<GuestDTO> getAllGuests() {

        return entityDAO.getAllGuests();

    }


    /**
     * add a guest
     *
     * @param guestDTO
     */
    public void addGuest(GuestDTO guestDTO) {

        entityDAO.addGuest(guestDTO);


    }

    /**
     * update the guest
     *
     * @param guestDTO
     */
    public void updateGuest(GuestDTO guestDTO) {

entityDAO.updateGuest( guestDTO);

    }

    /**
     * delete a guest
     *
     * @param guestId
     * @return true if the delete successful
     */
    public boolean deleteGuest(int guestId) {

        return entityDAO.deleteGuest( guestId);


    }

    /**
     * get a geust as a DTO
     *
     * @param guestId
     * @return
     */
    public SingleGuestDTO getGuest(int guestId) {


        GuestEntity guestEntity = guestRepository.findById(guestId).get();
        return guestTransformation.convertToSingleGuestDTO(guestEntity);
    }

    public SingleGuestDetailsDTO getGuestNew(int guestId) {
       return entityDAO.getGuestNew( guestId);
    }
}
