package model;

import model.exceptions.IDNotValidException;

public class MovieEdition extends Edition{
    private long IMDBN;

    public long getID() {
        return IMDBN;
    }

    // EFFECTS: throws an exception if IMDB Code of the edition is not valid
    //          otherwise does nothing
    @Override
    public void checkIDValidity() throws IDNotValidException {

    }
}
