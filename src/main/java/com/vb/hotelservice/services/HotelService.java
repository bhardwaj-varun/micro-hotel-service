package com.vb.hotelservice.services;

import com.vb.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getHotels() ;
    Hotel getHotel(String id);
    Hotel save(Hotel hotel);
}
