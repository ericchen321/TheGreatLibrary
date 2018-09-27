package tests;

import model.Book;
import model.Bookshelf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBookshelf {
    private Bookshelf bookshelf;

    // helper for checking book info, returns true if info is correct
    private boolean checkBookInfo(Book book, String name, String author, String genre, int yop){
       return (book.getBookName().equals(name)
               && book.getBookAuthorName().equals(author)
               && book.getGenre().equals(genre)
               && book.getYearOfPublish()==yop);
    }

    @BeforeEach
    public void setUp(){
        bookshelf = new Bookshelf();
    }

    @Test
    public void testAddBookAddOneBook(){
        Book book0;
        assertTrue(bookshelf.addBook("LOL", "Eric", "art",2018));
        book0 = bookshelf.getBook(0);
        assertTrue(checkBookInfo(book0, "LOL","Eric","art",2018));
    }

    @Test
    public void testAddBookAddTwoBooks(){
        Book book0, book1;
        assertTrue(bookshelf.addBook("BNW", "Huxley", "fiction", 1932));
        assertTrue(bookshelf.addBook("Haha", "Jemma", "biography",2010));
        book0 = bookshelf.getBook(0);
        book1 = bookshelf.getBook(1);
        assertTrue(checkBookInfo(book0,"BNW","Huxley","fiction",1932));
        assertTrue(checkBookInfo(book1,"Haha","Jemma","biography",2010));
    }

    @Test
    public void testGetBookNoBooks(){
        assertEquals(null, bookshelf.getBook(0));
        assertEquals(null, bookshelf.getBook(1));
        assertEquals(null, bookshelf.getBook(-1));
    }

    @Test
    public void testGetBookHasBookOutOfBound(){
        Book book0, book1;
        assertTrue(bookshelf.addBook("BNW", "Huxley", "fiction", 1932));
        assertTrue(bookshelf.addBook("Haha", "Jemma", "biography",2010));
        assertEquals(null, bookshelf.getBook(-1));
        assertEquals(null, bookshelf.getBook(2));
    }

}
