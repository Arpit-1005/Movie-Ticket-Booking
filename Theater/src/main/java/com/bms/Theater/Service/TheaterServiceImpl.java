package com.bms.Theater.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.Theater.Entity.Theater;
import com.bms.Theater.Repository.TheaterRepository;

@Service
public class TheaterServiceImpl implements TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    @Override
    public String createTheater(Theater theater) {
        theaterRepository.save(theater);
        return "Theater added successfully";
    }

    @Override
    public List<Theater> readTheaters() {
        return theaterRepository.findAll();
    }

    @Override
    public Theater readTheater(Long id) {
        return theaterRepository.findById(id).get();
    }

    @Override
    public String updateTheater(Long id, Theater theater) {
        Theater existingTheater = theaterRepository.findById(id).get();
        existingTheater.setTheaterName(theater.getTheaterName());
        existingTheater.setTheaterCity(theater.getTheaterCity());
        existingTheater.setAddress(theater.getAddress());
        theaterRepository.save(existingTheater);
        return "Theater updated successfully";
    }

    @Override
    public boolean deleteTheater(Long id) {
        theaterRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Theater> readTheatersByCity(String city) {
        return theaterRepository.findByTheaterCity(city);
    }
    
}
