package model;

import model.exceptions.IDNotValidException;

public class MovieEdition extends Edition{
    // constructors
    public MovieEdition(){}

    // MODIFIES: this
    // EFFECTS: makes a new movie edition but
    //          throws IDNotValidException if IMDBN code is not valid:
    //                 IMDBN contains not only numbers OR
    //                 IMDBN of the edition is not 9 digits long
    public MovieEdition(String publisher, int yop, String imdbn) throws IDNotValidException {
        super(publisher, yop, imdbn);
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

        if(ID.length() != 9){
            throw new IDNotValidException();
        }
    }
}
