package model;

import model.exceptions.EditionAlreadyExistException;

import java.io.IOException;

public class Movie extends Artwork {

    // FIXME: takes care of the DEFAULT_PUBLISH_YEAR
    // constructors
    // EFFECTS: constructs a movie with given name and director's name;
    //          this movie's genre is set to uncategorized;
    //          this movie's publish year is set to given year
    //          add this movie to the director's list of works
    public Movie(String name, String director, int yop){
        super(name, "", yop);
        this.creator = new Director(director);
        this.creator.addWork(this);
    }

    // EFFECTS: constructs a movie with given name, director, year of publish;
    //          if given genre can be recognized then set the movie to given genre,
    //          otherwise set movie's genre to be uncategorized;
    //          add this movie to the director's works
    public Movie(String name, String director, String genre, int yop){
        super(name, genre, yop);
        this.creator = new Director(director);
        this.creator.addWork(this);
    }

    // setters and getters

    // MODIFIES: this
    // EFFECTS: if given director does not have same name
    //          then remove this movie from current director's books
    //          AND set movie's director to given one
    //          AND add this movie to given director's work
    //          else if given director has the same name but is not the current one
    //          then throws SameCreatorAsPreviousException
    //          else (given is the current) does nothing
    public void setDirector(Director director) {
        super.setCreator(director);
    }

    public String getDirectorName() {
        return super.getCreatorName();
    }

    public Director getDirector(){
        return (Director) super.getCreator();
    }

    // REQUIRES: given edition is an edition of this movie
    // MODIFIES: this
    // EFFECTS: if given edition exists then do not add, and throws EditionAlreadyExistException
    //          else add given edition, register this movie for given edition,
    //          update this's publish year, and return true
    public void addEdition(Edition movieEd) throws EditionAlreadyExistException {
        super.addEdition(movieEd);
    }

    // TODO: tests and imp
    // MODIFIES: this
    // EFFECTS: fetches rating from IMDB
    public void fetchRating() throws IOException{

    }
}
