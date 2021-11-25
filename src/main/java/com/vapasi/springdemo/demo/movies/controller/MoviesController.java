package com.vapasi.springdemo.demo.movies.controller;

import com.vapasi.springdemo.demo.movies.dto.Movies;
import com.vapasi.springdemo.demo.movies.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {

    private MoviesService moviesService;

    @Autowired
    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }


    @GetMapping("/")
    public ResponseEntity<List<Movies>> getAllMovies(){
         List<Movies> allMovies=moviesService.getAllMovies();
         return ResponseEntity.ok().body(allMovies);
    }

    @PostMapping("/")
    public ResponseEntity<Movies> saveMovie(@RequestBody Movies movie){
        Movies savedMovie=moviesService.saveMovie(movie);
        return new ResponseEntity<> (savedMovie,HttpStatus.CREATED);

    }


}
