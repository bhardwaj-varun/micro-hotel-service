package com.vb.hotelservice.controllers;

import com.vb.hotelservice.entities.Hotel;
import com.vb.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    ResponseEntity<List<Hotel>> getAllHotels(){
        return  new ResponseEntity<>(hotelService.getHotels(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Hotel> getHotelById(@PathVariable String id){
        return new ResponseEntity<>(hotelService.getHotel(id), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        String id = UUID.randomUUID().toString();
        hotel.setId(id);
        return new ResponseEntity<>(hotelService.save(hotel), HttpStatus.CREATED);
    }
}
