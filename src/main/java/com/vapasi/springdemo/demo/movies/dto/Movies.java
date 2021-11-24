package com.vapasi.springdemo.demo.movies.dto;

import java.util.Objects;

public class Movies {
    private String name;
    private String directorName;
    private String actorName;

    public Movies(String name, String directorName, String actorName) {
        this.name = name;
        this.directorName = directorName;
        this.actorName = actorName;
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
        Movies movies = (Movies) o;
        return name.equals(movies.name) && directorName.equals(movies.directorName) && actorName.equals(movies.actorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, directorName, actorName);
    }

    @Override
    public String toString() {
        return "Movies{" +
                "name='" + name + '\'' +
                ", directorName='" + directorName + '\'' +
                ", actorName='" + actorName + '\'' +
                '}';
    }
}
