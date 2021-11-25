package com.vapasi.springdemo.demo.movies.service;

import com.vapasi.springdemo.demo.movies.dto.Movies;
import com.vapasi.springdemo.demo.movies.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {

    private MoviesRepository moviesRepository;

    @Autowired
    public MoviesService(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public List<Movies> getAllMovies() {
        return moviesRepository.getAllMovies();
    }

    public Movies saveMovie(Movies movie) {
        return moviesRepository.saveMovie(movie);
    }
}
