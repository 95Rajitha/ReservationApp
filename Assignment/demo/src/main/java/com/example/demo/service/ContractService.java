package com.example.demo.service;

import com.example.demo.model.Entity.Dao.EntityDAO;
import com.example.demo.repository.ContractRepository;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.restDto.ContractDTO;
import com.example.demo.restDto.ContractRequestDTO;
import com.example.demo.restDto.ContractRequestDTONew;
import com.example.demo.service.transformers.ContractTransformation;
import com.example.demo.validation.ContractValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContractTransformation contractTransformation;
    @Autowired
    private ContractValidation contractValidation;
    @Autowired
    private EntityDAO entityDAO;

    /**
     * update a contract
     *
     * @param contractRequestDTO
     */
    public void updateContract(ContractRequestDTO contractRequestDTO) {

        entityDAO.updateContract(contractRequestDTO);


    }

    /**
     * get all the contracts
     *
     * @return
     */
    public List<ContractDTO> getAllContracts() {

        return entityDAO.getAllContracts();

    }

    /**
     * get a  contract by an ID
     *
     * @param contractId
     * @return
     */
    public ContractDTO getContract(Integer contractId) {

        return entityDAO.getContract(contractId);

    }


    /**
     * contract DR
     *
     * @param contractRequestDTO
     */
    public void addContract(ContractRequestDTO contractRequestDTO) {

        entityDAO.addContract(contractRequestDTO);


    }

    /**
     * delete a contract
     *
     * @param contractId
     * @return
     */
    public boolean deleteContract(int contractId) {
        return entityDAO.deleteContract(contractId);
    }

    public void addContract1(ContractRequestDTONew contractRequestDTONew) {

        entityDAO.addContract1(contractRequestDTONew) ;
    }
}
