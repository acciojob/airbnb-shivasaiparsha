package com.driver.controllers;

import com.driver.model.Booking;
import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.model.User;
import io.swagger.models.auth.In;

import java.util.List;
import java.util.UUID;
public class Service {

    Repositary repo = new Repositary();

    public String addhotel(Hotel h)
    {
        return repo.add(h);
    }

    public Integer getAdhar(User u)
    {
        return repo.addUserTODB(u);
    }

    public String getHotelFacility()
    {
        return repo.getHotel();
    }

    public int getCost(Booking book)
    {
        UUID id = UUID.randomUUID();
        String uid = id.toString();
        return repo.cost(book, uid);
    }

    public int getBookingdone(Integer aadhar)
    {
       return repo.getBookingsDone(aadhar);
    }

    public Hotel getHotelWithFacilities(List<Facility> f, String name)
    {
        return repo.getHotelWithNewFacilities(f, name);
    }
}
