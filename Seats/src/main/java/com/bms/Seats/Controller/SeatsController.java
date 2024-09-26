package com.bms.Seats.Controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.Seats.Entity.Seats;
import com.bms.Seats.Service.SeatsService;

@RestController
@RequestMapping("/seats")
public class SeatsController {

    @Autowired
    private SeatsService seatsService;
    
    @PostMapping("/create")
    public String createSeats(@RequestBody Map<String, String> request) {
        String noOfSeats = request.get("noOfSeats");
        String seatsType = request.get("seatsType");
        return seatsService.createSeats(noOfSeats, seatsType);
    }

    @GetMapping("/{seatsType}")
    public List<Seats> getSeatByType(@PathVariable String seatsType) {
        return seatsService.getSeatByType(seatsType);
    }
    
    @GetMapping("/{seatsType}/{noOfSeats}")
    public List<Seats> findSeatsByTypeAndNumber(@PathVariable String seatsType, @PathVariable String noOfSeats) {
        return seatsService.findSeatsByTypeAndNumber(seatsType, noOfSeats);
    }
}
