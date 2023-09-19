package com.vb.hotelservice.services.impl;

import com.vb.hotelservice.entities.Hotel;
import com.vb.hotelservice.exceptions.ResourceNotFoundException;
import com.vb.hotelservice.repositories.HotelRepository;
import com.vb.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel by not found with id: "+ id));
    }

    @Override
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
}
