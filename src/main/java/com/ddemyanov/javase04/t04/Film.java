package com.ddemyanov.javase04.t04;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

@Getter
@Setter
public class Film implements Serializable{

    private String name;
    private ArrayList<String> actors;

    public Film(String name) {
        this.name = name;
        actors = new ArrayList<>();
    }

    public void addActors(String ... actors){
        Collections.addAll(this.actors, actors);
    }

}
