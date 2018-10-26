package model;
import model.exceptions.IDNotValidException;

import java.util.Objects;

public abstract class Edition {
    protected String publisher;
    protected int yearOfPublish;
    protected String ID;

    // constructors
    public Edition(){}

    // EFFECTS: create an edition of a book or movie with
    //          given publisher, year published, and an ID
    public Edition(String publisher, int yop, String id){
        this.publisher = publisher;
        this.yearOfPublish = yop;
        this.ID = id;
    }

    // setters and getters
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
