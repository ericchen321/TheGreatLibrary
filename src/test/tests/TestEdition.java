package tests;

import model.*;
import model.exceptions.EditionAlreadyExistException;
import model.exceptions.IDNotValidException;
import model.exceptions.SameWorkAsPreviousException;
import model.exceptions.WorkAlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestEdition {
    private Book book;
    private Movie movie;
    private Edition bookEdition;
    private Edition movieEdition;

    @BeforeEach
    public void setUp(){
        book = new Book("HP", "JKR", "fiction", 2005);
        movie = new Movie("ET","Steven S","fantasy", 1984);

        try{
            bookEdition = new BookEdition("RH",2005,"1234567890");
            movieEdition = new MovieEdition("Universal", 1982, "000083866");
        }
        catch (IDNotValidException e){}
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
            Book identicalBook = new Book("HP", "JKR", "fiction", 2005);
            bookEdition.setArtwork(identicalBook);
            fail("should not be able to set again since an identical but not the same book has aleady been set");
        }
        catch (SameWorkAsPreviousException e){}

    }

    @Test
    public void testSetYearOfPublishUpdatesToEarlierYear(){
        try{
            bookEdition.setArtwork(book);
        }
        catch (SameWorkAsPreviousException e){
            fail("Should set work fine");
        }
        bookEdition.setYearOfPublish(2002);
        assertEquals(2002, book.getYearOfPublish());
    }
}
