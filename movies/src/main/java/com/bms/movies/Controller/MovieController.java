package com.bms.movies.Controller;

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

import com.bms.movies.Model.Movie;
import com.bms.movies.Service.MovieService;

@RestController
@RequestMapping("/Movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public String addMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @GetMapping
    public List<Movie> getAllMoive() {
        return movieService.readMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.readMovie(id);
    }

    @GetMapping("/city/{city}")
    public List<Movie> getMoviesByCity(@PathVariable String city) {
        return movieService.readMoviesByCity(city);
    }
    
    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable Long id) {
        if(movieService.deleteMovie(id)) {
            return "Movie deleted successfully";
        }
        return "Movie not found";
    }

    @PutMapping("/{id}")
    public String updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }
}
