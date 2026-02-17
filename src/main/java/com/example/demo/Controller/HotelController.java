package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.HotelDTO;
import com.example.demo.Service.HotelService;


@RestController
public class HotelController {
	
	 private HotelService hotelService;
	 public HotelController(HotelService hotelService) {
	        this.hotelService = hotelService;
	    }
	 
	 // ✅ Save Hotel (POST)
    @PostMapping("send")
    public HotelDTO saveHotel(@RequestBody HotelDTO hotelDTO) {
        return hotelService.saveHotel(hotelDTO);
    }

    // ✅ Get Hotel By ID (GET)
    @GetMapping("/{id}")
    public HotelDTO getHotelById(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }

    // ✅ Get All Hotels (GET)
    @GetMapping
    public List<HotelDTO> getAllHotels() {
        return hotelService.getAllHotels();
    }

    // ✅ Delete Hotel By ID (DELETE)
    @DeleteMapping("/{id}")
    public String deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return "Hotel deleted successfully oook then if you want to add then add the hotel";
    }
}
