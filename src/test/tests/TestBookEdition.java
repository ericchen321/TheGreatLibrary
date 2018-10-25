package tests;

import model.BookEdition;
import model.exceptions.IDNotValidException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class TestBookEdition {
    private BookEdition bookEd;

    @BeforeEach
    public void setUp(){
        bookEd = new BookEdition();
    }

   @Test
    public void testConstructorValidInfoMakeBookEdSuccessfully(){
        try{
            bookEd = new BookEdition("AB",1999,"1000000000");
            bookEd = new BookEdition("CD",2000,"1000000000000");
        }
        catch (IDNotValidException e){
            fail("id is valid");
        }
   }

   @Test
    public void testConstructorIDContainsNonIntThrowsIDNotValidExcep(){
        try{
            bookEd = new BookEdition("AB",1997,"12e3332134412");
            fail("id should be invalid");
        }
        catch (IDNotValidException e){}
   }

   @Test
    public void testConstructorIDLengthWrongThrowsIDNotValidExcep(){
        try{
            bookEd = new BookEdition("AB",1998,"447");
            fail("id should be invalid");
        }
        catch (IDNotValidException e){}
   }
}
