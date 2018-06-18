package com.ddemyanov.javase04.t04;

import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Дана коллекция фильмов, содержащая информацию об актерах,
 * снимавшихся в главных ролях(один актер мог сниматься в нескольких фильмах).
 * Необходимо написать приложение, позволяющее при запуске восстанавливать коллекцию фильмов, позволяя ее
 * модифицировать, а по завершению работы - сохранять в файл.
 * Для восстановления/сохранения использовать сериализацию/десериализацию.
 */
@Getter
@Setter
public class FIlmCollection implements Serializable {

    private static ArrayList<Film> films;
    static {

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("temp"));
            films = (ArrayList<Film>) ois.readObject();
            System.err.println("Loaded");
        } catch (Exception e) {
            films = new ArrayList <> ();
            System.err.println("New collection");
        }
    }

    public static void main(String[] args) throws IOException {
//        Film f = new Film("Apocalypto");
//        f.addActors("hector", "alice", "actor 3", "sfsefs");
//        addFilm(f);

        printFilms();
        exit();
    }

    static void exit() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp"));
        oos.writeObject(films);
        oos.flush();
        oos.close();
        System.err.println("Saved!");
    }

    static void addFilm(Film film){
        films.add(film);
    }

    static void printFilms(){
        for (Film f : films){
            System.out.println("Film name: " + f.getName());
            System.out.println("Actors: ");
            for(String s : f.getActors()){
                System.out.println(s);
            }
        }
    }
}
