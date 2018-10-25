package tests;

import model.BookEdition;
import model.Edition;
import model.MovieEdition;
import model.exceptions.IDNotValidException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class TestEdition {
    private Edition bookEdition;
    private Edition movieEdition;

    @BeforeEach
    public void setUp(){
        bookEdition = new BookEdition();
        movieEdition = new MovieEdition();
    }

    // TODO: need to include call to MovieEdition's constructor
    @Test
    public void testConstructor(){
        try{
            bookEdition = new BookEdition("RH",2005,"1234567890");
            bookEdition = new BookEdition("RH",2010,"1000000000000");
        }
        catch (IDNotValidException e){
            fail("IDs are all valid");
        }
    }
}
