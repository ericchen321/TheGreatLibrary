package model;

import model.exceptions.EditionAlreadyExistException;
import model.exceptions.IDNotValidException;
import model.exceptions.WorkAlreadyExistException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MovieShelf extends Shelf{

    // MODIFIES: This
    // EFFECTS: if movie with same name & director is not on the shelf yet
    //          adds a movie to the movieshelf with given name, director, genre (if not
    //          recognized then will be classified as uncategorized), year of publish
    //          AND returns this movie
    //          otherwise does not add the movie and throws WorkAlreadyExistException
    public Movie addMovie(String name, String director, String genre, int yop) throws WorkAlreadyExistException {
        Movie movie = new Movie(name, director, genre, yop);
        super.addWork(movie);
        return movie;
    }

    // TODO: test
    // EFFECTS: if movie with given name and director exists
    //          then return the number of editions
    //          else return 0
    public int getEditionSize(String movieName, String directorName){
        return super.getEditionSize(new Movie(movieName, directorName));
    }

    // MODIFIES: this
    // EFFECT: write movies in text file with given path name to the shelf
    public void loadFromFile(String pathName){
        try{
            List<String> lines = Files.readAllLines(Paths.get(pathName));
            for (String line : lines){
                ArrayList<String> entries = splitOnSlash(line);
                try{
                    addMovie(entries.get(0),entries.get(1),entries.get(2),Integer.parseInt(entries.get(3)));
                }
                catch (WorkAlreadyExistException bae){
                    // just chill
                }
            }
        }
        catch(IOException excep){
            excep.printStackTrace();
        }
    }

    // MODIFIES: this
    // EFFECTS: throws IDNotValidException if given IMDBN is not valid (contains
    //          non-numbers or is not 9-digits long)
    //          else if edition already exists
    //               throws EditionAlreadyExistException
    //          else if movie of given edition not on the movieshelf yet then add movie & edition
    //                 & returns edition
    //          else add edition with given information to the given movie & update movie's publish year
    //                 & returns edition
    public void addEdition(String movieName, String directorName, String publisher, int yop, String isbn)
            throws IDNotValidException,EditionAlreadyExistException {
        MovieEdition movieEd = new MovieEdition(publisher,yop,isbn);
        Movie movie = new Movie(movieName, directorName);
        super.addEdition(movie, movieEd);
    }
}
