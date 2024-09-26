package com.bms.Theater.Service;

import java.util.List;

import com.bms.Theater.Entity.Theater;


public interface TheaterService {
    String createTheater(Theater theater);
    List<Theater> readTheaters();
    Theater readTheater(Long id);
    String updateTheater(Long id, Theater theater);
    boolean deleteTheater(Long id);
    List<Theater> readTheatersByCity(String city);
    
}
