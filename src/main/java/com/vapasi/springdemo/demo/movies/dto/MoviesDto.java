package com.vapasi.springdemo.demo.movies.dto;

import com.vapasi.springdemo.demo.movies.entity.MoviesEntity;

import java.util.Objects;

public class MoviesDto {
    private Integer id;
    private String name;
    private String directorName;
    private String actorName;

    public MoviesDto(Integer id, String name, String directorName, String actorName) {
        this.id = id;
        this.name = name;
        this.directorName = directorName;
        this.actorName = actorName;
    }

    public static MoviesDto createDtoFrom(MoviesEntity movieEntity) {
        return new MoviesDto(movieEntity.getId(), movieEntity.getName(), movieEntity.getDirectorName(), movieEntity.getActorName());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String getActorName() {
        return actorName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesDto moviesDto = (MoviesDto) o;
        return id == moviesDto.id && name.equals(moviesDto.name) && directorName.equals(moviesDto.directorName) && actorName.equals(moviesDto.actorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, directorName, actorName);
    }

    @Override
    public String toString() {
        return "MoviesDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", directorName='" + directorName + '\'' +
                ", actorName='" + actorName + '\'' +
                '}';
    }
}
