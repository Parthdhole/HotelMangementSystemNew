package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.HotelEntitiy;

public interface HotelRepository extends JpaRepository<HotelEntitiy, Long> {
	

}
