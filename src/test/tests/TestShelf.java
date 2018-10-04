package tests;

import model.Book;
import model.Bookshelf;
import model.MovieShelf;
import model.Shelf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestShelf {
    private Shelf bookshelf;
    private Shelf movieshelf;

    @BeforeEach
    public void setUp(){
        bookshelf = new Bookshelf();
        movieshelf = new MovieShelf();
    }

    // TODO: test for movieshelf
    @Test
    public void testAddAddOneNoReplica(){
        assertTrue(bookshelf.add("LOL","Eric","art",2018));
        assertTrue(bookshelf.add("LOL","Jemma","art",2018));
        assertTrue(bookshelf.add("LOL","Eric","fiction",2018));
        assertTrue(bookshelf.add("LOL","Eric","art",1999));
    }

    // TODO: test for movieshelf
    @Test
    public void testAddAddTwoOneReplica(){
        assertTrue(bookshelf.add("BNW", "Huxley", "fiction", 1932));
        assertFalse(bookshelf.add("BNW", "Huxley", "fiction",1932));
    }
}
