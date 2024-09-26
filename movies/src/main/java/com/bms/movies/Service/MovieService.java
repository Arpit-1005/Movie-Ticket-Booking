package com.bms.movies.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bms.movies.Model.Movie;

@Service
public interface MovieService {
    String createMovie(Movie movie);
    List<Movie> readMovies();
    Movie readMovie(Long id);
    String updateMovie(Long id, Movie movie);
    boolean deleteMovie(Long id);
    List<Movie> readMoviesByCity(String city);    
} 
