package tests;

import model.BookEdition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBookEdition {
    private BookEdition bookEd;

    @BeforeEach
    public void setUp(){
        bookEd = new BookEdition();
    }

    // TODO
    @Test
    public void BookEditionCreateAnEdition(){}

    // TODO
    @Test
    public void checkIDValidityISBNContainsNonNumberChars(){}

    // TODO
    @Test
    public void checkIDValidityISBNNotTenDigitsBefore2007(){}

    // TODO
    @Test
    public void checkIDValidityISBNNotThirteenDigitsAfter2007(){}
}
