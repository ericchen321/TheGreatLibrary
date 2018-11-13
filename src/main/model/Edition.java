package model;
import model.exceptions.EditionAlreadyExistException;
import model.exceptions.IDNotValidException;
import model.exceptions.WorkAlreadyExistException;

import java.util.Objects;

public abstract class Edition {
    protected Artwork artwork;
    protected String publisher;
    protected int yearOfPublish;
    protected String ID;

    // constructors
    public Edition(){};

    // EFFECTS: create an edition of a book or movie with
    //          given publisher, year published, and an ID
    public Edition(String publisher, int yop, String id){
        this.publisher = publisher;
        this.yearOfPublish = yop;
        this.ID = id;
    }

    // setters and getters
    // REQUIRES: this edition is an edition of the given artwork
    // MODIFIES: this, aw
    // EFFECTS: if given artwork equals this edition's current artwork but is not the same
    //          then throws WorkAlreadyExistException
    //          else if given artwork equals current one and is the same
    //          then does nothing
    //          else register given artwork for this edition
    //          AND remove association with previous edition
    //          AND add this edition to given artwork's registered editions
    public void setArtwork(Artwork aw) throws WorkAlreadyExistException{
        if (aw.equals(artwork) && aw == artwork){
            throw new WorkAlreadyExistException();
        }
        else if(!aw.equals(artwork)){
            if (artwork != null){
                artwork.removeEdition(this);
            }
            artwork = aw;
            try{
                aw.addEdition(this);
            }
            catch (EditionAlreadyExistException e){}
        }
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
        if (o == null || getClass() != o.getClass()) return false;
        Edition edition = (Edition) o;
        return Objects.equals(ID, edition.ID);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID);
    }
}
