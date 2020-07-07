package com.example.demo.repository;

import com.example.demo.model.Entity.HotelEntity;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<HotelEntity,Integer> {
}
