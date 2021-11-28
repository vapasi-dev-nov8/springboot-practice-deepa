package com.vapasi.springdemo.demo.movies.repository;

import com.vapasi.springdemo.demo.movies.entity.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MoviesRepository extends JpaRepository<MoviesEntity,Integer> {
    List<MoviesEntity> findByActorName(String actorName);
    List<MoviesEntity> findByActorNameIn(List<String> actorNames);
}
