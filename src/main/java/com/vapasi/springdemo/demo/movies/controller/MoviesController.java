package com.vapasi.springdemo.demo.movies.controller;

import com.vapasi.springdemo.demo.movies.dto.MoviesDto;
import com.vapasi.springdemo.demo.movies.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {

    private MoviesService moviesService;

    @Autowired
    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }


   @GetMapping("/")
    public ResponseEntity<List<MoviesDto>> getAllMovies(){
         List<MoviesDto> allMovies=moviesService.getAllMovies();
         return ResponseEntity.ok().body(allMovies);
    }

    @PostMapping("/")
    public ResponseEntity<MoviesDto> saveMovie(@RequestBody MoviesDto moviesDto){
        MoviesDto savedMovie=moviesService.save(moviesDto);
        return new ResponseEntity<> (savedMovie,HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<MoviesDto> getMovieById(@PathVariable Integer id){
        Optional<MoviesDto> movie=moviesService.getMovieById(id);
        return ResponseEntity.ok().body(movie.get());

    }


}
