package com.bms.Seats.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.Seats.Entity.Seats;
import com.bms.Seats.Repository.SeatsRepository;

@Service
public class SeatsServiceImpl implements SeatsService {

	@Autowired
	private SeatsRepository seatsRepository;

    @Override
    public String createSeats(String noOfSeats, String seatsType) {
        int numberOfSeats = Integer.parseInt(noOfSeats);
        List<Seats> seats = new ArrayList<>();
        int seatNumber = 1;
        char row = 'A';
        for (int i = 0; i < numberOfSeats; i++) {
            Seats seat = new Seats();
            seat.setNoOfSeats(row + "" + seatNumber);
            seat.setSeatsType(seatsType);
            seats.add(seat);
            seatNumber++;
            if (seatNumber > 10) {
                seatNumber = 1;
                row++;
            }
        }
        seatsRepository.saveAll(seats);
        return "Seats created successfully";
    }

    @Override
    public List<Seats> getSeatByType(String seatsType) {
        return seatsRepository.findBySeatsType(seatsType);
    }
    
    @Override
    public List<Seats> findSeatsByTypeAndNumber(String seatsType, String noOfSeats) {
        return seatsRepository.findBySeatsTypeAndNoOfSeats(seatsType, noOfSeats);
    }
    
}