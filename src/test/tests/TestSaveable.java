package tests;

import model.Bookshelf;
import model.Loadable;
import model.Saveable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestSaveable {
    private Bookshelf bookshelf;
    private Saveable bookshelfsaveable;
    private Bookshelf bookshelf1;
    private Loadable bookshelfloadable;

    @BeforeEach
    public void setUp(){
        bookshelf = new Bookshelf();
        bookshelf1 = new Bookshelf();
        bookshelfsaveable = bookshelf;
        bookshelfloadable = bookshelf1;
    }

    // TODO: need to test for movie
    @Test
    public void testPrintToFile(){
        bookshelf.add("Digital Design","Dally","uncategorized",2000);
        bookshelf.add("The Great Gatsby","Fitzgerald","fiction",1925);
        bookshelfsaveable.printToFile("src/testIOFiles/testPrintToFileBookshelf.txt");
        bookshelfloadable.loadFromFile("src/testIOFiles/testPrintToFileBookshelf.txt");
        assertFalse(bookshelf1.add("Digital Design","Dally","uncategorized",2000));
        assertFalse(bookshelf1.add("The Great Gatsby","Fitzgerald","fiction",1925));
    }
}
