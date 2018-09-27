package tests;

import model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBook {
    private Book book;

    @BeforeEach
    public void setup(){
        book = new Book();
    }

    @Test
    public void testBookGivenAllInfo(){
        book = new Book("LOL", "Eric", "fiction",2018);
        assertTrue(book.getBookName().equals("LOL"));
        assertTrue(book.getBookAuthorName().equals("Eric"));
        assertTrue(book.getGenre().equals("fiction"));
        assertEquals(2018,book.getYearOfPublish());
    }

    @Test
    public void testResolveGenre(){
        assertEquals(Book.Genre.ART, book.resolveGenre("art"));
        assertEquals(Book.Genre.BIOGRAPHY, book.resolveGenre("biography"));
        assertEquals(Book.Genre.CLASSICS, book.resolveGenre("classics"));
        assertEquals(Book.Genre.FANTASY, book.resolveGenre("fantasy"));
        assertEquals(Book.Genre.FICTION, book.resolveGenre("fiction"));
        assertEquals(Book.Genre.HISTORY, book.resolveGenre("history"));
        assertEquals(Book.Genre.UNCATAGORIZED, book.resolveGenre("scifi"));
        assertEquals(Book.Genre.UNCATAGORIZED, book.resolveGenre(""));
    }
}
