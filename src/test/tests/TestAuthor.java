package tests;

import model.Author;
import model.Book;
import model.exceptions.SameAuthorAsPreviousException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class TestAuthor {
    private Author author;

    @BeforeEach
    public void setUp(){
        author = new Author("Amy");
    }

    @Test
    public void testSearchBookBookExists(){
        Book book = new Book("Amy's book","Amy","",1990);
        author = book.getAuthor();
        assertTrue(author.searchBook(book));
    }

    @Test
    public void testSearchBookBookDoesNotExist(){
        Book book = new Book("Joe's book", "Joe","",1991);
        assertFalse(author.searchBook(book));
    }

    @Test
    public void testAddBookBookHasAuthorWithSameNameExpectsSameAuthorAsPreviousException(){
        Book book = new Book("Amy's book","Amy","",1990);
        try{
            author.addBook(book);
            fail("book already has an author with same name");
        }
        catch (SameAuthorAsPreviousException e){}
    }

    @Test
    public void testAddBookExpectsPreviousAuthorReplaced(){
        Book book = new Book("Amy's book","Joe","",1990);
        Author prevAuthor = book.getAuthor();
        author.addBook(book);
        assertTrue(author.searchBook(book));
        assertTrue(author==book.getAuthor());
        assertFalse(prevAuthor.searchBook(book));
    }
}
