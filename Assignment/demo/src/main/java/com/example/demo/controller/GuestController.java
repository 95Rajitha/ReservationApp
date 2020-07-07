package com.example.demo.controller;

import com.example.demo.model.Entity.GuestEntity;
import com.example.demo.restDto.GuestDTO;
import com.example.demo.restDto.SingleGuestDetailsDTO;
import com.example.demo.service.GuestService;
import com.example.demo.service.transformers.GuestTransformation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8081"},
        maxAge = 4800, allowCredentials = "false")

@RestController
public class GuestController {

    @Autowired
    private GuestService guestService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private GuestTransformation guestTransformation;

    /**
     * get all the guests
     * @return
     */
//    @CrossOrigin(origins = "http://localhost:8081")
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET,value = "/guest")
    public List<GuestDTO> getAllGuest(){
        return guestService.getAllGuests();
    }


    /**
     * add a guest
     * @param guestDTO
     */
    @PostMapping("/guest")
    public void addGuest(@RequestBody GuestDTO guestDTO){
        guestService.addGuest(guestDTO);
    }

    /**
     * update a guest
     * @param guestDTO
     */
    @PutMapping("/guest")
    public  void  updateGuest(@RequestBody GuestDTO guestDTO){
        guestService.updateGuest(guestDTO);
    }

    /**
     * delete a guest
     * @param guestId
     * @return
     */
    @DeleteMapping("/guest/{guestId}")
    public boolean deleteGuest(@PathVariable int guestId){
        return guestService.deleteGuest(guestId);
    }

    /**
     * get a guest
     * @param guestId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "guest/{guestId}")
    public SingleGuestDetailsDTO getGuestNew(@PathVariable int guestId){
        return guestService.getGuestNew(guestId);
    }


}
