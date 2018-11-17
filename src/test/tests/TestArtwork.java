package tests;

import model.Artwork;
import model.Book;
import model.Movie;
import model.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestArtwork {
    private Artwork book;
    private Artwork movie;

    @BeforeEach
    public void setUp(){
        book = new Book("HP", "JKR",1999);
        movie = new Movie("2001","SK",1964);
    }

    @Test
    public void testSetRatingGivenValidNumericalRating(){
        book.setRating(4.2);
        Rating r = book.getRating();
        assertEquals(4.2, r.getRating());
        assertEquals(book,r.getArtwork());
    }

    // TODO: need more tests for setRating(s)
}
