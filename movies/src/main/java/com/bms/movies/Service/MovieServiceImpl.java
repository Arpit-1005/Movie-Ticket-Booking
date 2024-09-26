package com.bms.movies.Service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.bms.movies.Entity.MovieEntity;
import com.bms.movies.Model.Movie;
import com.bms.movies.Repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public String createMovie(Movie movie) {
        MovieEntity movieEntity = new MovieEntity();
        BeanUtils.copyProperties(movie, movieEntity);
        movieRepository.save(movieEntity);
        return "movie added successfully";      
    }

    @Override
    public List<Movie> readMovies() {
        List<MovieEntity> moviesList = movieRepository.findAll();
        List<Movie> movies = new ArrayList<>();
        for (MovieEntity movieEntity : moviesList) {
            Movie movie = new Movie();
            BeanUtils.copyProperties(movieEntity, movie);
            movies.add(movie);
        }
        return movies;
    }

    @Override
    public Movie readMovie(Long id) {
        MovieEntity movieEntity = movieRepository.findById(id).get();
        Movie movie = new Movie();
        BeanUtils.copyProperties(movieEntity, movie);
        return movie;       
    }

    @Override
    public String updateMovie(Long id, Movie movie) {
        MovieEntity extistingMovie = movieRepository.findById(id).get();
        extistingMovie.setMovieName(movie.getMovieName());
        extistingMovie.setDuration(movie.getDuration());
        extistingMovie.setDate(movie.getDate());
        extistingMovie.setTime(movie.getTime());
        extistingMovie.setCity(movie.getCity());
        movieRepository.save(extistingMovie);
        return "movie updated successfully";   
    }

    @Override
    public boolean deleteMovie(Long id) {
        MovieEntity movie = movieRepository.findById(id).get();
        movieRepository.delete(movie);
        return true;
    }

    @Override
    public List<Movie> readMoviesByCity(String City) {
        List<MovieEntity> moviesList = movieRepository.findByCity(City);
        List<Movie> movies = new ArrayList<>();
        for (MovieEntity movieEntity : moviesList) {
            Movie movie = new Movie();
            BeanUtils.copyProperties(movieEntity, movie);
            movies.add(movie);
        }
        return movies;
    }

    
    
}
