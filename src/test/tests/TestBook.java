package tests;

import model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBook {
    private Book book;

    // helper for checking book info, returns true if info is correct
    private static boolean checkBookInfo(Book book, String name, String author, String genre, int yop){
        return (book.getBookName().equals(name)
                && book.getBookAuthorName().equals(author)
                && book.getGenre().equals(genre)
                && book.getYearOfPublish()==yop);
    }

    @BeforeEach
    public void setup(){
        book = new Book();
    }

    @Test
    public void testBookGivenAllInfo(){
        book = new Book("LOL", "Eric", "fiction",2018);
        checkBookInfo(book,"LOL","Eric","fiction",2018);
    }
}
