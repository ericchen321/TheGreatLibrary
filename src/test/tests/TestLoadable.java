package tests;

import model.Bookshelf;
import model.Loadable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

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
    public void testLoadFromFileAddOneFile(){
        bookshelfloadable.loadFromFile("src/testIOFiles/testScanFromFileAddOneFile.txt");
        assertFalse(bookshelf.add("Special Relativity","Joe","uncategorized",2000));
        assertFalse(bookshelf.add("How to Play League Right","Bill","biography",2014));
        assertFalse(bookshelf.add("Reddit it","Jemma","fiction",2012));
    }
}
