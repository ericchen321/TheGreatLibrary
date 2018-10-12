package model;

import model.exceptions.IDNotValidException;

public class BookEdition extends Edition{

    // constructors
    public BookEdition(){}

    // TODO: need tests
    public BookEdition(String publisher, int yop, long isbn){
        super(publisher, yop, isbn);
    }

    // EFFECTS: throws an exception if ISBN of the edition is not valid
    //          otherwise does nothing
    @Override
    public void checkIDValidity() throws IDNotValidException {
        if (yearOfPublish >= 2017 && ID < 1000000000000L){
            throw new IDNotValidException();
        }
        else if (yearOfPublish < 2017 && (ID >= 9999999999L || ID < 1000000000)){
            throw new IDNotValidException();
        }
    }
}
