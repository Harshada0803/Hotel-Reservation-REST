package com.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.model.GuestReservationDetails;

public interface GuestDetailsRepository extends CrudRepository<GuestReservationDetails, Long>{
}
