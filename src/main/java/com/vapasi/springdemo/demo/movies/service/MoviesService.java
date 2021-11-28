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
        List<MoviesDto> moviesDtoList= new ArrayList<>();
        List<MoviesEntity> moviesEntityList = moviesRepository.findAll();
        return createDtosFromEntities(moviesEntityList, moviesDtoList);
    }

    public MoviesDto save(MoviesDto moviesDto) {
        MoviesEntity savedMovieEntity = moviesRepository.save(MoviesEntity.createEntityFrom(moviesDto));
        return MoviesDto.createDtoFrom(savedMovieEntity);
    }

    public Optional<MoviesDto> getMovieById(Integer id) {
        Optional<MoviesEntity> moviesEntity = moviesRepository.findById(id);
        //return Optional.of(MoviesDto.createDtoFrom(moviesEntity.get()));
        return moviesEntity.map(MoviesDto::createDtoFrom);
    }

    public List<MoviesDto> getAllMoviesOfActor(String actorName) {
        List<MoviesDto> moviesDtoList=new ArrayList<>();
        List<MoviesEntity> moviesEntityList = moviesRepository.findByActorName(actorName);
        if(!moviesEntityList.isEmpty())
            moviesDtoList = createDtosFromEntities(moviesEntityList, moviesDtoList);
        return moviesDtoList;
    }

    public MoviesDto updateMovie(MoviesDto moviesDto) {

        MoviesEntity moviesEntity = MoviesEntity.createEntityFrom(moviesDto);
        MoviesEntity storedMovie = moviesRepository.findById(moviesEntity.getId()).orElse(moviesEntity);

        storedMovie.setName(moviesEntity.getName());
        storedMovie.setActorName(moviesEntity.getActorName());
        storedMovie.setDirectorName(moviesEntity.getDirectorName());

        return MoviesDto.createDtoFrom(moviesRepository.save(storedMovie));

    }

    public List<MoviesDto> getAllMoviesOfActors(List<String> actorNames) {
        List<MoviesDto> moviesDtoList=new ArrayList<>();
        List<MoviesEntity> moviesEntityList = moviesRepository.findByActorNameIn(actorNames);
        if(!moviesEntityList.isEmpty()){
            moviesDtoList = createDtosFromEntities(moviesEntityList, moviesDtoList);
        }
        return moviesDtoList;
    }

    private List<MoviesDto> createDtosFromEntities(List<MoviesEntity> moviesEntityList, List<MoviesDto> moviesDtoList) {
        for(MoviesEntity moviesEntity : moviesEntityList){
            moviesDtoList.add(MoviesDto.createDtoFrom(moviesEntity));
        }
        return moviesDtoList;
    }
}
