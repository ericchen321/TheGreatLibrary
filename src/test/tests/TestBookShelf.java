package tests;

import model.BookEdition;
import model.Bookshelf;
import model.exceptions.EditionAlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(bookshelf.add("UAS","Jemma","fiction",2018));
    }

    @Test
    public void testAddAddTwoOneReplica(){
        assertTrue(bookshelf.add("BNW", "Huxley", "fiction", 1932));
        assertFalse(bookshelf.add("BNW", "Huxley", "fiction",1932));
    }

    @Test
    public void testAddEditionToBookshelfNoBook(){
        try{
            bookshelf.addEditionToBookshelf("The Hot Zone", "R Preston","Anchor Books",1999 ,"9780385495226");
        }
        catch (Exception e){
            fail("should add successfully");
        }
        assertFalse(bookshelf.add("The Hot Zone","R Preston","uncategorized",1999));
        try{
            bookshelf.addEditionToBookshelf("The Hot Zone", "R Preston","Anchor Books",1999 ,"9780385495226");
            fail("Expects fail to add when adding again");
        }
        catch (EditionAlreadyExistException e){}
        catch (Exception e){
            fail("no other exceptions should occur");
        }
        assertEquals(1,bookshelf.getEditionSize("The Hot Zone", "R Preston"));
    }
}
