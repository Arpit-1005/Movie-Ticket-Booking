package com.bms.Seats.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.Seats.Entity.Seats;

@Repository
public interface SeatsRepository extends JpaRepository<Seats, Long> {

    List<Seats> findBySeatsType(String seatsType);

    List<Seats> findBySeatsTypeAndNoOfSeats(String seatsType, String noOfSeats);
}
