package tests;

import model.BookEdition;
import model.Edition;
import model.MovieEdition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEdition {
    private Edition bookEdition;
    private Edition movieEdition;

    @BeforeEach
    public void setUp(){
        bookEdition = new BookEdition();
        movieEdition = new MovieEdition();
    }

    // TODO
    @Test
    public void checkIDValidityValidID(){

    }

    // TODO
    @Test
    public void checkIDValidityInvalidID(){

    }
}
