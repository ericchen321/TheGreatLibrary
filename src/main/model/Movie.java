package model;

import java.util.ArrayList;
import java.util.List;

public class Movie{

    private enum Genre {
        ART, BIOGRAPHY, CLASSICS, FANTASY, HISTORY, FICTION, UNCATAGORIZED
    }

    private String name;
    private Artist director;
    private List<Artist> stars;
    private int yearOfPublish;
    private Genre genre;

    // constructor
    public Movie(){}
}
