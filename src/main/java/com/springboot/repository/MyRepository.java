package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.model.Guest;

public interface MyRepository extends CrudRepository<Guest, Long>{
	public Guest findByGuestEmailId(String email);

}
