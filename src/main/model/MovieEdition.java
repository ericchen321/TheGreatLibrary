package model;

import model.exceptions.IDNotValidException;

public class MovieEdition extends Edition{

    public String getID() {
        return ID;
    }

    // EFFECTS: throws an exception if IMDB Code of the edition is not valid
    //          otherwise does nothing
    @Override
    public void checkIDValidity() throws IDNotValidException {

    }
}
