package tests;

import model.Book;
import model.Movie;
import model.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestRating {
    private Book book;
    private Movie movie;
    private Rating bookRating;
    private Rating movieRating;

    @BeforeEach
    public void setUp(){
        book = new Book("A Game of Thrones", "George Martin");
        bookRating = new Rating(book, 0);
    }

    // FIXME: not done
    @Test
    public void testFetchRatingIsAssociatedWithBook(){
        try{
            bookRating.fetch();
            assertEquals(4.45, bookRating.getRating());
        }
        catch (IOException e){
            fail("Oops");
        }
    }
}
