package tests;

import model.BookEdition;
import model.exceptions.IDNotThirteenDigitException;
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
        catch (IDNotThirteenDigitException e){
            fail("ID is 13 digits");
        }
        catch (IDNotValidException e){}
   }

   @Test
    public void testConstructorIDLengthWrongThrowsIDNotValidExcep(){
        try{
            bookEd = new BookEdition("AB",1998,"447");
            fail("id should be invalid");
        }
        catch (IDNotThirteenDigitException e){
            fail("not 10 or 13 digits");
        }
        catch (IDNotValidException e){}
   }

   @Test
    public void testConstructorIDLengthIsTenDigitsAfter2007ThrowsIDNot13DigitsExcep(){
        try{
            bookEd = new BookEdition("AB",2011,"1000000000");
            fail("id is not valid");
        }
        catch (IDNotThirteenDigitException e){}
        catch (IDNotValidException e){
            fail("should can ID not 13 digits excep instead");
        }
   }
}
