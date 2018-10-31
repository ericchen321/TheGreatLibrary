package model;

public class Director extends Artist{

    // constructors
    public Director(String name) {
        super(name);
    }

    public String getArtistType(){
        return "director";
    }

    // MODIFIES: this
    // EFFECTS: if given movie has director with same name but the director is not this
    //          then throws SameCreatorAsPreviousException
    //          otherwise add given movie to this director's movies and set given movie's director to this
    public void addMovie (Movie movie){
        super.addWork(movie);
    }

    // EFFECTS: returns true if the director has directed the given movie
    //                  false
    public boolean searchMovie(Movie movie){
        return super.searchWork(movie);
    }
}
