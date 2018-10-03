package model;

import java.util.ArrayList;
import java.util.List;

public class Movie{

    private enum Genre {
        ART, BIOGRAPHY, CLASSICS, FANTASY, HISTORY, FICTION, UNCATAGORIZED
    }

    private String name;
    private Artist director = new Director();
    private List<Artist> stars = new ArrayList<>();
    private int yearOfPublish;
    private Genre genre;

    // constructor
    public Movie(){}
}
