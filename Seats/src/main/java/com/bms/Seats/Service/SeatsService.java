package com.bms.Seats.Service;

import java.util.List;

import com.bms.Seats.Entity.Seats;

public interface SeatsService {
    String createSeats(String noOfSeats, String seatsType);
    List<Seats> getSeatByType(String seatsType);
    List<Seats> findSeatsByTypeAndNumber(String seatsType, String noOfSeats);
}
