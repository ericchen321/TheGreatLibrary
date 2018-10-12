package model;
import model.exceptions.IDNotValidException;

public abstract class Edition {
    protected String publisher;
    protected int yearOfPublish;
    protected long ID;

    // constructors
    public Edition(){}

    // TODO: need tests
    public Edition(String publisher, int yop, long id){
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

    public long getID(){
        return ID;
    };

    // EFFECTS: throws an exception if ID of the edition is not valid
    //          otherwise does nothing
    public abstract void checkIDValidity() throws IDNotValidException;
}
