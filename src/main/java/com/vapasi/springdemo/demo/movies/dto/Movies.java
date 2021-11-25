package com.vapasi.springdemo.demo.movies.dto;

import java.util.Objects;

public class Movies {
    private int id;
    private String name;
    private String directorName;
    private String actorName;

    public Movies(int id, String name, String directorName, String actorName) {
        this.id = id;
        this.name = name;
        this.directorName = directorName;
        this.actorName = actorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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


}
