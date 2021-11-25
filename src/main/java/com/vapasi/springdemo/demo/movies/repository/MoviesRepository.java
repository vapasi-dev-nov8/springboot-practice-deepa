package com.vapasi.springdemo.demo.movies.repository;

import com.vapasi.springdemo.demo.movies.dto.Movies;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MoviesRepository {
    List<Movies> movieList=new ArrayList<>();
    {
        movieList.add(new Movies(101,"Knives Out","Ryan Johnson","Chris Evans"));
        movieList.add(new Movies(102,"Brick","Ryan Johnson","Lukas Hass"));
        movieList.add(new Movies(103,"Munich","Steven SpielBerg","Daniel Craig"));

    }

    public List<Movies> getAllMovies() {
        return movieList;
    }

    public Movies saveMovie(Movies movie) {
       int id = movieList.get(movieList.size() - 1).getId() + 1;
       movieList.add(new Movies(id, movie.getName(), movie.getDirectorName(), movie.getActorName()));
       return movieList.get(movieList.size() - 1);

    }
}
