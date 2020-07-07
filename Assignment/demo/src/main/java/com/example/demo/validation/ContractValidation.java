package com.example.demo.validation;

import com.example.demo.model.Entity.HotelEntity;
import com.example.demo.model.Entity.UserEntity;
import com.example.demo.repository.ContractRepository;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.restDto.ContractRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContractValidation {

@Autowired
private UserRepository userRepository;

@Autowired
private HotelRepository hotelRepository;

    public boolean EntityValidation(ContractRequestDTO contractRequestDTO) {

        Boolean isUserEntityExists = userRepository.findById(contractRequestDTO.getUserID()).isPresent();
        Boolean isHotelEntityExists = hotelRepository.findById(contractRequestDTO.getHotelID()).isPresent();
        return isHotelEntityExists && isUserEntityExists;
    }
}
