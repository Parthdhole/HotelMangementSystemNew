package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
	
        private Long id;
        private String hotelName;
	    private String city;
	    private String address;
	    private double pricePerNight;
	    private boolean available;
}
