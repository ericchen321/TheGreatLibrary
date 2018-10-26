package model;

import model.exceptions.IDNotValidException;

import java.text.ParseException;

public class BookEdition extends Edition{

    // constructors
    public BookEdition(){}

    // MODIFIES: this
    // EFFECTS: makes a new book edition and
    //          throws an exception if ISBN code is not valid:
    //          ISBN contains not only numbers OR
    //          ISBN of the edition is not 10 or 13 digits long
    public BookEdition(String publisher, int yop, String isbn) throws IDNotValidException {
        super(publisher, yop, isbn);
        checkIDValidity();
    }

    // EFFECTS: throws an exception if ISBN contains not only numbers
    //                                 OR ISBN of the edition is not 10 or 13 digits long
    //          otherwise does nothing
    private void checkIDValidity() throws IDNotValidException {
        try{
            Long.parseLong(ID);
        }
        catch (NumberFormatException nfE){
            throw new IDNotValidException();
        }

        if(ID.length() != 10 && ID.length() != 13){
            throw new IDNotValidException();
        }
    }
}
