package com.example.demo.service.transformers;

import com.example.demo.model.Entity.ContractEntity;
import com.example.demo.model.Entity.HotelEntity;
import com.example.demo.model.Entity.UserEntity;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.restDto.ContractDTO;
import com.example.demo.restDto.ContractRequestDTO;
import com.example.demo.restDto.ContractRequestDTONew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContractTransformation {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HotelRepository hotelRepository;

    /**
     * convert to ContraactDTO object
     *
     * @param allContractEntities
     * @return
     */
    public List<ContractDTO> convertToContractDTOS(List<ContractEntity> allContractEntities) {

        List<ContractDTO> contractDTOList = new ArrayList<>();
        allContractEntities.forEach(contractEntity -> {
            contractDTOList.add(convertToContractDTO(contractEntity));
        });
        return contractDTOList;
    }


    public ContractEntity convertToContractEntity(ContractRequestDTO contractRequestDTO) {

        UserEntity userEntity = userRepository.findById(contractRequestDTO.getUserID()).get();
        HotelEntity hotelEntity = hotelRepository.findById(contractRequestDTO.getHotelID()).get();

        ContractEntity contractEntity = new ContractEntity();
        contractEntity.setContractId(contractRequestDTO.getContractId());
        contractEntity.setStartDate(contractRequestDTO.getStartDate());
        contractEntity.setEndDate(contractRequestDTO.getEndDate());
        contractEntity.setHotelEntity(hotelEntity);
        contractEntity.setUserEntity(userEntity);

        return contractEntity;

    }

    public ContractDTO convertToContractDTO(ContractEntity contractEntity) {

        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setContractId(contractEntity.getContractId());
        contractDTO.setStartDate(contractEntity.getStartDate());
        contractDTO.setEndDate(contractEntity.getEndDate());
        contractDTO.setHotelId(contractEntity.getHotelEntity().getHotelId());
        contractDTO.setHotelName(contractEntity.getHotelEntity().getHotelName());
        contractDTO.setUserId(contractEntity.getUserEntity().getUserId());
        contractDTO.setUserName(contractEntity.getUserEntity().getUserName());
        return contractDTO;

    }

    public boolean userEntityValidation1(int userID) {

        return userRepository.findById(userID).isPresent();

    }

    public ContractEntity convertToContractEntity1(ContractRequestDTONew contractRequestDTONew) {

        ContractEntity contractEntity = new ContractEntity();
        contractEntity.setContractId(contractRequestDTONew.getContractId());
        contractEntity.setStartDate(contractRequestDTONew.getStartDate());
        contractEntity.setEndDate(contractRequestDTONew.getEndDate());
        return contractEntity;
    }
}
