package model;

import model.exceptions.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// TODO: need a test class for Artwork
/* CLASS INVARIANTS: name should not be null, creator should not be null*/
public abstract class Artwork {
    protected static final int DEFAULT_PUBLISH_YEAR = -1000;

    protected enum Genre {
        ART, BIOGRAPHY, CLASSICS, FANTASY, HISTORY, FICTION, UNCATEGORIZED
    }
    protected String name;
    protected Artist creator;
    protected int yearOfPublish;
    protected Rating rating;
    protected Genre genre;
    protected List<Edition> editions = new ArrayList<>();

    // constructors
    // MODIFIES: this
    // EFFECTS: set this work's name, genre, year published;
    //          initialize rating to 0
    public Artwork(String name, String genre, int yop){
        setName(name);
        setGenre(genre);
        setYearOfPublish(yop);
        setRating(0);
    }

    // setters and getters
    public void setName(String name) {
        this.name = name;
    }

    public void setYearOfPublish(int yOfp) {
        yearOfPublish = yOfp;
    }

    // TODO: tests
    // MODIFIES: this
    // EFFECTS: sets this's rating to given rating
    //          AND register this artwork for its rating
    public void setRating(double rating) {
        try{
            setRating(new Rating(this, rating));
        }
        catch (SameWorkAsPreviousException e){}
    }

    // TODO: tests
    // MODIFIES: this
    // EFFECTS: if this's rating is not the same as given
    //          then deregister this work from current rating
    //               AND sets this's rating to given rating
    //               AND register this artwork for given rating
    //                   (possibly throws SameWorkAsPreviousException if an equal work is register
    //                   for given rating)
    //          else does nothing
    public void setRating(Rating r) throws SameWorkAsPreviousException{
        if(this.rating != r){
            if (this.rating != null){
                this.rating.removeWork();
            }
            this.rating = r;
            this.rating.setArtwork(this);
        }
    }

    // MODIFIES: this
    // EFFECTS: set this's rating to undefined
    public void removeRating(){
        this.rating = null;
    };

    // MODIFIES:this
    // EFFECTS: sets this work's genre to given one if genre is recognizable
    //          otherwise sets genre to uncategorized
    public void setGenre(String genre){
        switch (genre) {
            case "art":
                this.genre = Genre.ART;
                break;
            case "biography":
                this.genre = Genre.BIOGRAPHY;
                break;
            case "classics":
                this.genre = Genre.CLASSICS;
                break;
            case "fantasy":
                this.genre = Genre.FANTASY;
                break;
            case "history":
                this.genre = Genre.HISTORY;
                break;
            case "fiction":
                this.genre = Genre.FICTION;
                break;
            default:
                this.genre = Genre.UNCATEGORIZED;
        }
    }

    // MODIFIES: this, creator
    // EFFECTS: if given creator does not have same name
    //          then removes this work from current creator's works
    //          AND set this work's creator to given one
    //          AND add this work to given creator's work
    //          else if given creator has the same name but is not the current one
    //          then throws SameCreatorAsPreviousException
    //          else (given is the current) does nothing
    public void setCreator(Artist creator) {
        if (!(this.creator == creator)) {
            if(this.creator.equals(creator)){
                throw new SameCreatorAsPreviousException();
            }
            this.creator.removeWork(this);
            this.creator = creator;
            this.creator.addWork(this);
        }
    }

    public String getName() {
        return name;
    }

    public Artist getCreator(){
        return creator;
    }

    public String getCreatorName(){
        return creator.getName();
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public Rating getRating(){
        return rating;
    }

    public double getRatingValue(){
        if(rating == null){
            throw new RatingNotSetException();
        }
        return rating.getRating();
    }

    public String getGenre(){
        switch (genre) {
            case ART:
                return "art";
            case BIOGRAPHY:
                return "biography";
            case CLASSICS:
                return "classics";
            case FANTASY:
                return "fantasy";
            case HISTORY:
                return "history";
            case FICTION:
                return "fiction";
            default:
                return "uncategorized";
        }
    }

    // EFFECTS: return the number of editions
    public int getEditionSize(){
        return editions.size();
    }

    public String toString(){
        return name + " by " + creator.getName() + " published in " + yearOfPublish;
    }

    // MODIFIES: this
    // EFFECTS: updates this's publish year by setting the year to the publish year
    //          of the earliest edition
    private void updateYearOfPub(){
        for (Edition e: editions){
            yearOfPublish = (e.getYearOfPublish() < yearOfPublish)? e.getYearOfPublish():yearOfPublish;
        }
    }

    // REQUIRES: given edition is an edition of this artwork
    // MODIFIES: this, ed
    // EFFECTS: if given edition exists then do not add, and throws EditionAlreadyExistException
    //          else add given edition
    //          AND register this work for the given edition
    //          AND update this work's publish year
    //          AND return true
    public void addEdition(Edition ed) throws EditionAlreadyExistException {
        for (Edition e: editions){
            if (e.equals(ed))
                throw new EditionAlreadyExistException();
        }
        editions.add(ed);
        try{
            ed.setArtwork(this);
        }
        catch (SameWorkAsPreviousException e){}
        updateYearOfPub();
    }

    // MODIFIES: this, edition
    // EFFECTS: remove given edition from editions registered for this work
    public void removeEdition(Edition edition){
        editions.remove(edition);
    }

    // MODIFES: this
    // EFFECTS: fetches rating from online
    public abstract void fetchRating() throws IOException;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artwork artwork = (Artwork) o;
        return Objects.equals(name, artwork.name) &&
                Objects.equals(creator, artwork.creator);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, creator);
    }
}
