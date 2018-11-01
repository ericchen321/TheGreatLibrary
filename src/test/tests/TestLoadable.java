package tests;

import model.Bookshelf;
import model.Loadable;
import model.exceptions.WorkAlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

public class TestLoadable {
    private Bookshelf bookshelf;
    private Loadable bookshelfloadable;

    @BeforeEach
    public void setUp(){
        bookshelf = new Bookshelf();
        bookshelfloadable = bookshelf;
    }

    // TODO: need to test for movie
    @Test
    public void testLoadFromFile(){
        bookshelfloadable.loadFromFile("src/testIOFiles/testScanFromFileBookshelf.txt");
        try{
            bookshelf.addBook("Special Relativity","Joe","uncategorized",2000);
            fail("SR should not be added");
        }
        catch (WorkAlreadyExistException e){}
        try {
            bookshelf.addBook("How to Play League Right", "Bill", "biography", 2014);
            fail("HtPLR should not be added");
        }
        catch (WorkAlreadyExistException e){}
        try {
            bookshelf.addBook("Reddit it", "Jemma", "fiction", 2012);
            fail("RI should not be added");
        }
        catch (WorkAlreadyExistException e){}
    }
}
