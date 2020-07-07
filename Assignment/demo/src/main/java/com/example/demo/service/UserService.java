package com.example.demo.service;

import com.example.demo.model.Entity.Dao.EntityDAO;
import com.example.demo.model.Entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.restDto.UserDTO;
import com.example.demo.service.transformers.UserTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserTransformation userTransformation;
    @Autowired
    private EntityDAO entityDAO;

    public List<UserDTO> getAllUsers() {

        return entityDAO.getAllUsers();


    }

    public void addUser(UserDTO userDTO) {

        entityDAO.addUser(userDTO);

    }

    public void updateUser(UserDTO userDTO) {

        entityDAO.updateUser(userDTO);


    }

    public boolean deleteUser(int userId) {


        return entityDAO.deleteUser(userId);



    }
}
