package com.example.demo.controller;

import com.example.demo.restDto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET,value = "/users")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/users")
    public void adduser(@RequestBody UserDTO userDTO){
        userService.addUser(userDTO);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/users")
    public void updateUser(@RequestBody UserDTO userDTO){
        userService.updateUser(userDTO);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/users/{userId}")
    public boolean deleteUser(@RequestParam int userId ){
      return   userService.deleteUser(userId);
    }

}
