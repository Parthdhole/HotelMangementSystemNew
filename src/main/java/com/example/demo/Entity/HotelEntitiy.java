package com.example.demo.Entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;

import lombok.*;

@Entity
@Table(name = "hotels_Entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelEntitiy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String hotelName;
    @Column(nullable = false)
    private String city;
    private String address;
    private double pricePerNight;
    private boolean available;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
