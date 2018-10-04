package tests;

import model.Bookshelf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBookShelf {
    private Bookshelf bookshelf;

    @BeforeEach
    public void setUp(){
        bookshelf = new Bookshelf();
    }

    @Test
    public void testAddAddOneNoReplica(){
        assertTrue(bookshelf.add("LOL","Eric","art",2018));
        assertTrue(bookshelf.add("LOL","Jemma","art",2018));
        assertTrue(bookshelf.add("LOL","Eric","fiction",2018));
        assertTrue(bookshelf.add("LOL","Eric","art",1999));
    }

    @Test
    public void testAddAddTwoOneReplica(){
        assertTrue(bookshelf.add("BNW", "Huxley", "fiction", 1932));
        assertFalse(bookshelf.add("BNW", "Huxley", "fiction",1932));
    }
}
