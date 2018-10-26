package tests;

import model.Book;
import model.BookEdition;
import model.exceptions.IDNotValidException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class TestBook {
    private Book book;

    @Test
    public void testBookGivenNameAndAuthorName(){
        book = new Book("LOL", "Eric");
        assertTrue(book.getBookName().equals("LOL")
                    && book.getBookAuthorName().equals("Eric")
                    && book.getGenre().equals("uncategorized"));
        assertTrue(book.getBookAuthor().searchBook(book));
    }

    @Test
    public void testBookGivenAllInfo(){
        book = new Book("LOL", "Eric", "fiction",2018);
        assertTrue(book.getBookName().equals("LOL")
                && book.getBookAuthorName().equals("Eric")
                && book.getGenre().equals("fiction")
                && book.getYearOfPublish()==2018);
        assertTrue(book.getBookAuthor().searchBook(book));
    }

    @Test
    public void testAddEditionEdDoesExistsExpectsReturnFalse(){
        book = new Book("Haha","ABC","biography",2010);
        try {
            BookEdition bookEd = new BookEdition("RH", 2010, "1234567890");
            assertTrue(book.addEdition(bookEd));
            assertFalse(book.addEdition(bookEd));
        }
        catch (IDNotValidException e){
            fail("should make book eds successfully");
        }
    }

    // TODO
    @Test
    public void testAddEditionEdDoesNotExistYoPEarlier(){

    }

    // TODO
    @Test
    public void testAddEditionEdDoesNotExistYoPLater(){

    }
}
