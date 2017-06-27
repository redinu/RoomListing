package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ListingRepository extends CrudRepository<Listing, Long>{

	
	List<Listing> findByIsRented(String isRented);
}
