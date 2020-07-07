package com.example.demo.service.transformers;

import com.example.demo.model.Entity.UserEntity;
import com.example.demo.restDto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserTransformation {


    public List<UserDTO> convertToUserDTO(List<UserEntity> allUsers) {

        List<UserDTO> userDTOList = new ArrayList<>();

        allUsers.forEach(userEntity -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setRole(userEntity.getRole());
            userDTO.setUserId(userEntity.getUserId());
            userDTO.setUserName(userEntity.getUserName());
            userDTOList.add(userDTO);
        });
        return userDTOList;

    }

    public UserEntity convertToUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setRole(userDTO.getRole());
        userEntity.setUserId(userDTO.getUserId());

        return userEntity;


    }
}
