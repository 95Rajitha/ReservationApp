package com.example.demo.repository;

import com.example.demo.model.Entity.GuestEntity;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<GuestEntity,Integer> {



}
