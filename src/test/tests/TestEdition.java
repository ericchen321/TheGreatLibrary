package tests;

import model.Book;
import model.BookEdition;
import model.Edition;
import model.MovieEdition;
import model.exceptions.EditionAlreadyExistException;
import model.exceptions.IDNotValidException;
import model.exceptions.SameWorkAsPreviousException;
import model.exceptions.WorkAlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    public void testSetArtwork(){
        Book book = new Book("HP", "JKR", "fiction", 2005);
        try{
            bookEdition = new BookEdition("RH",2005,"1234567890");
        }
        catch (IDNotValidException e){}
        try{
            bookEdition.setArtwork(book);
            assertEquals(book, bookEdition.getArtwork());
        }
        catch (SameWorkAsPreviousException e){
            fail("should set artwork successfully in first trial");
        }
        try{
            book.addEdition(bookEdition);
            fail("should not be able to add again since has already added");
        }
        catch (EditionAlreadyExistException e){}
        try{
            bookEdition.setArtwork(book);
            fail("should not be able to set again since has aleady set");
        }
        catch (SameWorkAsPreviousException e){}

    }
}
