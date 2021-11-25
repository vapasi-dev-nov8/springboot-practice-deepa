package com.vapasi.springdemo.demo.movies.service;

import com.vapasi.springdemo.demo.movies.dto.MoviesDto;
import com.vapasi.springdemo.demo.movies.entity.MoviesEntity;
import com.vapasi.springdemo.demo.movies.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {

    private MoviesRepository moviesRepository;

    @Autowired
    public MoviesService(MoviesRepository moviesRepository) {

        this.moviesRepository = moviesRepository;
    }

    public List<MoviesDto> getAllMovies() {
        List<MoviesDto> allMoviesDto= new ArrayList<>();
        for (MoviesEntity moviesEntity : moviesRepository.findAll()) {
            allMoviesDto.add(MoviesDto.createDtoFrom(moviesEntity));
        }
        return allMoviesDto;
    }

    public MoviesDto save(MoviesDto moviesDto) {
        MoviesEntity moviesEntity=MoviesEntity.createEntityFrom(moviesDto);
        MoviesEntity savedMovieEntity = moviesRepository.save(moviesEntity);
        MoviesDto savedMovieDto=MoviesDto.createDtoFrom(savedMovieEntity);
        return savedMovieDto;
    }

    public Optional<MoviesDto> getMovieById(Integer id) {
        Optional<MoviesEntity> moviesEntity = moviesRepository.findById(id);
        //return MoviesDto.createDtoFrom(moviesEntity);
        return moviesEntity.map(MoviesDto::createDtoFrom);
    }
}
