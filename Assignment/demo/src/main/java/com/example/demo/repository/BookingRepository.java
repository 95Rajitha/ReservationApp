package com.example.demo.repository;

import com.example.demo.model.Entity.BookingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface BookingRepository extends CrudRepository<BookingEntity,Integer> {

    List<BookingEntity> findAllByCheckInDateGreaterThanEqualAndCheckOutDateIsLessThanEqual(Date checkInDate, Date checkOutDate);
    List<BookingEntity> findAllByCheckInDateLessThanAndCheckOutDateGreaterThan(Date checkInDate, Date checkOutDate);
    List<BookingEntity> findAllByCheckInDateLessThanAndCheckOutDateLessThan(Date checkInDate, Date checkOutDate);
    List<BookingEntity> findAllByCheckInDateGreaterThanAndCheckOutDateGreaterThan(Date checkInDate, Date checkOutDate);

}
