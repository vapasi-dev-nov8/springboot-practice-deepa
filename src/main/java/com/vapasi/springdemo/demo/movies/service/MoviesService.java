package com.vapasi.springdemo.demo.movies.service;

import com.vapasi.springdemo.demo.movies.dto.Movies;
import com.vapasi.springdemo.demo.movies.repository.MoviesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {

    MoviesRepository moviesRepository;

    public MoviesService(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public List<Movies> getAllMovies() {
        return moviesRepository.getAllMovies();
    }
}
