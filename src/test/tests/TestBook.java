package tests;

import model.Author;
import model.Book;
import model.BookEdition;
import model.exceptions.EditionAlreadyExistException;
import model.exceptions.IDNotValidException;
import model.exceptions.SameAuthorAsPreviousException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBook {
    private Book book;

    @BeforeEach
    public void setUp(){
        book = new Book("Whatever","Doe","biography",1980);
    }

    @Test
    public void testBookGivenNameAndAuthorName(){
        book = new Book("LOL", "Eric");
        assertEquals("LOL",book.getName());
        assertEquals("Eric",book.getAuthorName());
        assertEquals("uncategorized",book.getGenre());
        assertTrue(book.getAuthor().searchBook(book));
    }

    @Test
    public void testBookGivenAllInfo(){
        book = new Book("LOL", "Eric", "fiction",2018);
        assertEquals("LOL",book.getName());
        assertEquals("Eric",book.getAuthorName());
        assertEquals("fiction",book.getGenre());
        assertTrue(book.getAuthor().searchBook(book));
    }

    @Test
    public void testAddEditionEdAlreadyExistsExpectEditionAlreadyExistsException(){
        book = new Book("Haha","ABC","biography",2010);
        try {
            BookEdition bookEd = new BookEdition("RH", 2010, "1234567890123");
            book.addEdition(bookEd);
            book.addEdition(bookEd);
            fail("should not addBook twice");
        }
        catch (IDNotValidException e){
            fail("should make book eds successfully");
        }
        catch (EditionAlreadyExistException e){}
    }

    @Test
    public void testAddEditionEdDoesNotExistYoPEarlier(){
        book = new Book("Haha","ABC","biography",2015);
        try{
            BookEdition bookEd = new BookEdition("RH", 2000, "1234567890");
            book.addEdition(bookEd);
        }
        catch (Exception e){fail("should create ed and add ed successfully");}
        assertEquals(2000,book.getYearOfPublish());
    }

    @Test
    public void testAddEditionEdDoesNotExistYoPLater(){
        book = new Book("Haha","ABC","biography",2015);
        try{
            BookEdition bookEd = new BookEdition("RH", 2018, "1234567890123");
            book.addEdition(bookEd);
        }
        catch (Exception e){fail("should create ed and add ed successfully");}
        assertEquals(2015,book.getYearOfPublish());
    }

    @Test
    public void testSetAuthorNewAuthorNewNameExpectsOldAuthorHasNoBooks(){
        Author oldAuthor = book.getAuthor();
        Author newAuthor = new Author("Kerr");
        book.setAuthor(newAuthor);
        assertTrue(newAuthor == book.getAuthor());
        assertTrue(newAuthor.searchBook(book));
        assertFalse(oldAuthor.searchBook(book));
    }

    @Test
    public void testSetAuthorNewAuthorOldNameExpectsSameAuthorAsPreviousException(){
        Author oldAuthor = book.getAuthor();
        Author newAuthor = new Author("Doe");
        try{
            book.setAuthor(newAuthor);
            fail("should not be able to add a different author with same name");
        }
        catch (SameAuthorAsPreviousException e){
            assertTrue(book.getAuthor() == oldAuthor);
            assertFalse(newAuthor.searchBook(book));
        }
    }

    @Test
    public void testSetAuthorNewAuthorSameAsOldAuthorExpectsNothingChanges(){
        Author newAuthor = book.getAuthor();
        book.setAuthor(newAuthor);
        assertTrue(newAuthor.searchBook(book));
    }
}
