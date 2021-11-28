package com.vapasi.springdemo.demo.movies.service;

import com.vapasi.springdemo.demo.movies.repository.MoviesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MoviesServiceIntegrationTest {

    @Autowired
    MoviesService moviesService;

    @Autowired
    MoviesRepository moviesRepository;

    @Test
    void getAllTheMoviesAddedToList(){

    }
}
