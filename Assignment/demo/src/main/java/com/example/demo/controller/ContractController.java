package com.example.demo.controller;

import com.example.demo.model.Entity.ContractEntity;
import com.example.demo.restDto.ContractDTO;
import com.example.demo.restDto.ContractRequestDTO;
import com.example.demo.restDto.ContractRequestDTONew;
import com.example.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ContractController {

    @Autowired
    private ContractService contractService;

    /**
     * getting all contracts
     * @return
     */
    @GetMapping("/contracts")
    public List<ContractDTO> getAllContracts(){
        return contractService.getAllContracts();

    }


    /**
     * get a single contract by ID
     * @param contractId
     * @return
     */
    @GetMapping("/contracts/{contractId}")
    public ContractDTO getContract(@PathVariable Integer contractId){
        return contractService.getContract(contractId);
    }


    /**
     * addd a contract
     * @param contractRequestDTO
     */
    @PostMapping("/contracts")
    public void addContract(@RequestBody ContractRequestDTO contractRequestDTO){
        contractService.addContract(contractRequestDTO);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/contracts1")
    public void addContract1(@RequestBody ContractRequestDTONew contractRequestDTONew){
        contractService.addContract1(contractRequestDTONew);
    }

    /**
     * update a contract
     * @param contractRequestDTO
     */
    @PutMapping("/contracts/update")
    public void updateContract(@RequestBody ContractRequestDTO contractRequestDTO){

        contractService.updateContract(contractRequestDTO);

    }


    /**
     * delete a contract
     * @param contractId
     * @return
     */
    @DeleteMapping("/contracts/{contractId}")
    public boolean deleteContract(@PathVariable int contractId){

        return !contractService.deleteContract(contractId);


    }





}
