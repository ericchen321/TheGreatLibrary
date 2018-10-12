package model;

import model.exceptions.IDNotValidException;

public class BookEdition extends Edition{

    // constructors
    public BookEdition(){}

    // TODO: need tests
    public BookEdition(String publisher, int yop, long isbn){
        super(publisher, yop, isbn);
    }

    // TODO: need tests and modify implmentation
    // EFFECTS: throws an exception if ISBN contains not only numbers
    //                                 OR ISBN of the edition is not 10 digits long
    //                                    and published before 2007
    //                                 OR ISBN of the edition is not 13 digits long
    //                                    and published after 2007
    //          otherwise does nothing
    @Override
    public void checkIDValidity() throws IDNotValidException {
        if (yearOfPublish >= 2007 && ID < 1000000000000L){
            throw new IDNotValidException();
        }
        else if (yearOfPublish < 2007 && (ID >= 9999999999L || ID < 1000000000)){
            throw new IDNotValidException();
        }
    }
}
