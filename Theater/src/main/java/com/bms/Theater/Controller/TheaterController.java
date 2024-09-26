package com.bms.Theater.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.Theater.Entity.Theater;
import com.bms.Theater.Service.TheaterService;

@RestController
@RequestMapping("/Theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping
    public String createTheater(@RequestBody Theater theater) {
        return theaterService.createTheater(theater);
    }

    @GetMapping
    public List<Theater> readTheaters() {
        return theaterService.readTheaters();
    }

    @GetMapping("/{theaterId}")
    public Theater readTheater(@PathVariable Long theaterId) {
        return theaterService.readTheater(theaterId);
    }

    @GetMapping("/city/{theaterCity}")
    public List<Theater> readTheatersByCity(@PathVariable String theaterCity) {
        return theaterService.readTheatersByCity(theaterCity);
    }

    @PutMapping("/{theaterId}")
    public String updateTheater(@PathVariable Long theaterId, @RequestBody Theater theater) {
        return theaterService.updateTheater(theaterId, theater);
    }

    @DeleteMapping("/{theaterId}")
    public String deleteTheater(@PathVariable Long theaterId) {
        if(theaterService.deleteTheater(theaterId)) {
            return "Theater deleted successfully";
        }
        return "Theater not found";
    }
}
