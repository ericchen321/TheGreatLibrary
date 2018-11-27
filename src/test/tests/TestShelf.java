package tests;

import model.Bookshelf;
import model.Movieshelf;
import model.Shelf;
import org.junit.jupiter.api.BeforeEach;

public class TestShelf {
    private Shelf bookshelf;
    private Shelf movieshelf;

    @BeforeEach
    public void setUp(){
        bookshelf = new Bookshelf();
        movieshelf = new Movieshelf();
    }

    // TODO: tests for getArtwork

}
