package model;
import model.exceptions.IDNotValidException;

public abstract class Edition {
    protected String publisher;
    protected int yearOfPublish;
    protected String ID;

    // constructors
    public Edition(){}

    // TODO: need tests
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

    // TODO: tests!
    // EFFECTS: throws an exception if ID of the edition is not valid
    //          otherwise does nothing
    protected abstract void checkIDValidity() throws IDNotValidException;
}
