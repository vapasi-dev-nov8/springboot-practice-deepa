package com.vapasi.springdemo.demo.movies.service;

import com.vapasi.springdemo.demo.movies.dto.MoviesDto;
import com.vapasi.springdemo.demo.movies.entity.MoviesEntity;
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

    /*public List<MoviesDto> getAllMovies() {
        return moviesRepository.getAllMovies();
    }*/

    public MoviesDto save(MoviesDto moviesDto) {
        MoviesEntity moviesEntity=MoviesEntity.createEntityFromDto(moviesDto);
        MoviesEntity savedMovieEntity = moviesRepository.save(moviesEntity);
        MoviesDto savedMovieDto=MoviesDto.createDtoFromEntity(savedMovieEntity);
        return savedMovieDto;
    }
}
