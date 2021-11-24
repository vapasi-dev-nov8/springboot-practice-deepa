package com.vapasi.springdemo.demo.movies.repository;

import com.vapasi.springdemo.demo.movies.dto.Movies;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MoviesRepository {
    List<Movies> movieList=new ArrayList<>();
    public List<Movies> getAllMovies() {
        movieList.add(new Movies("Knives Out","Ryan Johnson","Chris Evans"));
        movieList.add(new Movies("Brick","Ryan Johnson","Lukas Hass"));
        movieList.add(new Movies("Munich","Steven SpielBerg","Daniel Craig"));
        return movieList;
    }
}
