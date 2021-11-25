package com.vapasi.springdemo.demo.movies.entity;

import com.vapasi.springdemo.demo.movies.dto.MoviesDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "movies")
public class MoviesEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String directorName;
    private String actorName;

    public MoviesEntity() {

    }

    public MoviesEntity(String name, String directorName, String actorName) {
        this.name = name;
        this.directorName = directorName;
        this.actorName = actorName;
    }

    public static MoviesEntity createEntityFrom(MoviesDto moviesDto) {
        return new MoviesEntity(moviesDto.getName(), moviesDto.getDirectorName(),moviesDto.getActorName());
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

    public void setName(String name) {
        this.name = name;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesEntity that = (MoviesEntity) o;
        return id == that.id && name.equals(that.name) && directorName.equals(that.directorName) && actorName.equals(that.actorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, directorName, actorName);
    }

    @Override
    public String toString() {
        return "MoviesEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", directorName='" + directorName + '\'' +
                ", actorName='" + actorName + '\'' +
                '}';
    }
}
