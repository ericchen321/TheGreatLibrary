package tests;

import model.Bookshelf;
import model.exceptions.WorkAlreadyExistException;
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
    public void testAddBookAddOneNoReplica(){
        try{
            bookshelf.addBook("LOL","Eric","art",2018);
            bookshelf.addBook("LOL","Jemma","art",2018);
            bookshelf.addBook("UAS","Jemma","fiction",2018);
        }
        catch (WorkAlreadyExistException e){
            fail("should add all 3 books successfully");
        }
    }

    @Test
    public void testAddBookAddTwoOneReplica(){
        try{
            bookshelf.addBook("BNW", "Huxley", "fiction", 1932);
        }
        catch (WorkAlreadyExistException e){
            fail("first book should be added successfully");
        }

        try {
            bookshelf.addBook("BNW", "Huxley", "fiction",1932);
            fail("2nd book should not be added");
        }
        catch (WorkAlreadyExistException e){}
    }

    @Test
    public void testAddEditionNoBook(){
        try{
            bookshelf.addEdition("The Hot Zone", "R Preston","Anchor Books",1999 ,"9780385495226");
        }
        catch (Exception e){
            fail("should addBook successfully");
        }

        try{
            bookshelf.addBook("The Hot Zone","R Preston","",1999);
            fail("should not be able to add book");
        }
        catch (WorkAlreadyExistException e){}

        try{
            bookshelf.addEdition("The Hot Zone", "R Preston","Anchor Books",1999 ,"9780385495226");
            fail("Expects fail to addBook when adding again");
        }
        catch (EditionAlreadyExistException e){}
        catch (Exception e){
            fail("no other exceptions should occur");
        }
        assertEquals(1,bookshelf.getEditionSize("The Hot Zone", "R Preston"));
    }
}
