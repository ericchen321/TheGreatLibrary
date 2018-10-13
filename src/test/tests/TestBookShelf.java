package tests;

import model.BookEdition;
import model.Bookshelf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        assertTrue(bookshelf.add("UAS","Jemma","fiction",2018));
    }

    @Test
    public void testAddAddTwoOneReplica(){
        assertTrue(bookshelf.add("BNW", "Huxley", "fiction", 1932));
        assertFalse(bookshelf.add("BNW", "Huxley", "fiction",1932));
    }

    @Test
    public void testAddEditionToBookshelfNoBook(){
        assertTrue(bookshelf.addEditionToBookshelf("The Hot Zone", "R Preston","Anchor Books",1999 ,"9780385495226"));
        assertFalse(bookshelf.add("The Hot Zone","R Preston","uncategorized",1999));
        assertEquals(1,bookshelf.getEditionSize("The Hot Zone", "R Preston"));
    }

    @Test
    public void testAddEditionToBookshelfBookExistsNoSameEdition(){
        bookshelf.add("The Hot Zone","R Preston","uncategorized",1999);
        assertTrue(bookshelf.addEditionToBookshelf("The Hot Zone","R Preston","Random House",1994,"9780679430940"));
        assertEquals(1,bookshelf.getEditionSize("The Hot Zone","R Preston"));
    }

    @Test
    public void testAddEditionToBookshelfBookExistsSameEditionExists(){
        bookshelf.add("The Hot Zone","R Preston","uncategorized",1999);
        assertTrue(bookshelf.addEditionToBookshelf("The Hot Zone","R Preston","Random House",1994,"9780679430940"));
        assertFalse(bookshelf.addEditionToBookshelf("The Hot Zone","R Preston","Random House",1994,"9780679430940"));
    }

}
