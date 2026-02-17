package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Dto.HotelDTO;
import com.example.demo.Entity.HotelEntitiy;
import com.example.demo.Repository.HotelRepository;

@Service
public class HotelService {

	
	private HotelRepository hotelRepository;
	
	public HotelService(HotelRepository hotelRepository) {
		this.hotelRepository=hotelRepository;
	}

	public HotelDTO saveHotel(HotelDTO hotelDTO) {
		// TODO Auto-generated method stub
		 
		
		//DTO TO ENTITY WE CAN DO HERE
		// DTO->ENTITY
		//when request come
		HotelEntitiy hotel = new HotelEntitiy();
		hotel.setHotelName(hotelDTO.getHotelName());
        hotel.setCity(hotelDTO.getCity());
        hotel.setPricePerNight(hotelDTO.getPricePerNight());
        hotel.setAvailable(hotelDTO.isAvailable());
        hotel.setCreatedAt(LocalDateTime.now());
        hotel.setUpdatedAt(LocalDateTime.now());
        System.out.println("data goes to dto to entity");
        
        HotelEntitiy savedHotel= hotelRepository.save(hotel);
		
        // ENTITY -> DTO
        // when we want a response
        HotelDTO response = new HotelDTO();
        response.setId(savedHotel.getId());
        response.setHotelName(savedHotel.getHotelName());
        response.setCity(savedHotel.getCity());
        response.setPricePerNight(savedHotel.getPricePerNight());
        response.setAvailable(savedHotel.isAvailable());

        
		return response;
	}

	
	 
	public HotelDTO getHotelById(Long id) {
		// TODO Auto-generated method stub
		
		Optional<HotelEntitiy> optional =hotelRepository.findById(id);
		if(optional.isPresent()) {
			HotelEntitiy  hotel=optional.get();
			HotelDTO dto = new HotelDTO();
			dto.setId(hotel.getId());  
			dto.setHotelName(hotel.getHotelName());
            dto.setCity(hotel.getCity());
            dto.setPricePerNight(hotel.getPricePerNight());
            dto.setAvailable(hotel.isAvailable());
            return dto;

			
		}
		
		
		return null;
	}
	
	public List<HotelDTO> getAllHotels() {

        List<HotelEntitiy> hotelList = hotelRepository.findAll();
        List<HotelDTO> dtoList = new ArrayList<>();

        for (HotelEntitiy hotel : hotelList) {
            HotelDTO dto = new HotelDTO();
            dto.setId(hotel.getId());
            dto.setHotelName(hotel.getHotelName());
            dto.setCity(hotel.getCity());
            dto.setPricePerNight(hotel.getPricePerNight());
            dto.setAvailable(hotel.isAvailable());

            dtoList.add(dto);
        }

        return dtoList;
    }
	public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
	
}
