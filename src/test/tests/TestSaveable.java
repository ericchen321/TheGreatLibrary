package tests;

import model.Bookshelf;
import model.Loadable;
import model.Saveable;
import model.exceptions.WorkAlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

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
        try{
            bookshelf.addBook("Digital Design","Dally","uncategorized",2000);
            bookshelf.addBook("The Great Gatsby","Fitzgerald","fiction",1925);
        }
        catch (WorkAlreadyExistException e){
            fail("Both should be added successfully");
        }
        bookshelfsaveable.printToFile("src/testIOFiles/testPrintToFileBookshelf.txt");
        bookshelfloadable.loadFromFile("src/testIOFiles/testPrintToFileBookshelf.txt");
        try{
            bookshelf1.addBook("Digital Design","Dally","uncategorized",2000);
            fail("DD should not be added");
        }
        catch (WorkAlreadyExistException e){}
        try{
            bookshelf1.addBook("The Great Gatsby","Fitzgerald","fiction",1925);
            fail("TGG should not be added");
        }
        catch (WorkAlreadyExistException e){}
    }
}
