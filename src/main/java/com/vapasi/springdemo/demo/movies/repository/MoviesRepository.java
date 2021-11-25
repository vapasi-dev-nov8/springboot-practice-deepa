package com.vapasi.springdemo.demo.movies.repository;

import com.vapasi.springdemo.demo.movies.entity.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MoviesRepository extends JpaRepository<MoviesEntity,Integer> {


}
