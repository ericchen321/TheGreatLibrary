package tests;

import model.Book;
import model.Bookshelf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBookshelf {
    private Bookshelf bookshelf;

    @BeforeEach
    public void setUp(){
        bookshelf = new Bookshelf();
    }

    @Test
    public void addBookAddOneBook(){
        Book book0;
        assertTrue(bookshelf.addBook("LOL", "Eric", "art",2018));
        book0 = bookshelf.getBook(0);
        assertEquals("LOL",book0.getBookName());
        assertEquals("Eric", book0.getBookAuthorName());
        assertEquals("art",book0.getGenre());
        assertEquals(2018, book0.getYearOfPublish());
    }

    @Test
    public void addBookAddTwoBooks(){
        Book book0, book1;
        assertTrue(bookshelf.addBook("BNW", "Huxley", "fiction", 1932));
        assertTrue(bookshelf.addBook("Haha", "Jemma", "biography",2010));
        book0 = bookshelf.getBook(0);
        book1 = bookshelf.getBook(1);
        assertEquals("BNW", book0.getBookName());
        assertEquals("Huxley", book0.getBookAuthorName());
        assertEquals("fiction", book0.getGenre());
        assertEquals(1932, book0.getYearOfPublish());
        assertEquals("Haha", book1.getBookName());
        assertEquals("Jemma",book1.getBookAuthorName());
        assertEquals("biography",book1.getGenre());
        assertEquals(2010,book1.getYearOfPublish());


    }

    @Test
    public void getBookNoBooks(){
        assertEquals(null, bookshelf.getBook(0));
        assertEquals(null, bookshelf.getBook(1));
        assertEquals(null, bookshelf.getBook(-1));
    }

    @Test
    public void getBookOneBook(){

    }

    @Test
    public void sortBooksByYearOfPubNoBooks(){

    }
}
