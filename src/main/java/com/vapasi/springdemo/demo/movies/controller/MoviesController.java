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
        return movie.map(moviesDto -> ResponseEntity.ok().body(moviesDto)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/actor")
    public ResponseEntity<List<MoviesDto>> getAllMoviesOfActor(@RequestParam(name="name") String actorName){
        List<MoviesDto> moviesOfActor=moviesService.getAllMoviesOfActor(actorName);

        if (!moviesOfActor.isEmpty()) {
            return ResponseEntity.ok().body(moviesOfActor);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/actors")
    public ResponseEntity<List<MoviesDto>> getAllMoviesOfGivenActors(@RequestParam(name="names") List<String> actorNames){
        List<MoviesDto> moviesOfActors=moviesService.getAllMoviesOfActors(actorNames);

        if (!moviesOfActors.isEmpty()) {
            return ResponseEntity.ok().body(moviesOfActors);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/")
    public ResponseEntity<MoviesDto> updateMovie(@RequestBody MoviesDto moviesDto){

        MoviesDto updatedMovie=moviesService.updateMovie(moviesDto);
        if(updatedMovie == null)
            return ResponseEntity.notFound().build();
        return new ResponseEntity<> (updatedMovie,HttpStatus.CREATED);

    }


}
