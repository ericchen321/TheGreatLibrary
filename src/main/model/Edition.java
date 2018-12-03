package model;
import model.exceptions.EditionAlreadyExistException;
import model.exceptions.SameWorkAsPreviousException;

import java.util.Objects;
import java.util.Observable;

public abstract class Edition extends Observable{
    protected Artwork artwork;
    protected String publisher;
    protected int yearOfPublish;
    protected String ID;

    // constructors
    public Edition(){};

    // EFFECTS: create an edition of a book or movie with
    //          given publisher, year published, and an ID
    public Edition(String publisher, int yop, String id){
        setPublisher(publisher);
        setYearOfPublish(yop);
        this.ID = id;
    }

    // setters and getters
    // REQUIRES: this edition is an edition of the given artwork
    // MODIFIES: this, aw
    // EFFECTS: if given artwork equals this edition's current artwork but is not the same
    //          then throws SameWorkAsPreviousException
    //          else if given artwork equals current one and is the same
    //          then does nothing
    //          else register given artwork for this edition
    //          AND remove association with previous edition
    //          AND add this edition to given artwork's registered editions
    public void setArtwork(Artwork aw) throws SameWorkAsPreviousException {
        if (aw.equals(artwork) && aw != artwork){
            throw new SameWorkAsPreviousException();
        }
        else if(!aw.equals(artwork)){
            if (artwork != null){
                artwork.removeEdition(this);
                deleteObserver(artwork);
            }
            artwork = aw;
            addObserver(artwork);
            try{
                aw.addEdition(this);
            }
            catch (EditionAlreadyExistException e){}
        }
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public void setYearOfPublish(int yop){
        yearOfPublish = yop;
        setChanged();
        notifyObservers(yop);
    }

    public Artwork getArtwork(){
        return artwork;
    }

    public int getYearOfPublish(){
        return yearOfPublish;
    }

    public String getPulisher(){
        return publisher;
    }

    public String getID(){
        return ID;
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edition)) return false;
        Edition edition = (Edition) o;
        return Objects.equals(ID, edition.ID);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID);
    }
}
