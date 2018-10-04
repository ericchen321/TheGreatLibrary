package tests;

import model.Book;
import model.Bookshelf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBookshelf {
    private Bookshelf bookshelf;

    @BeforeEach
    public void setUp(){
        bookshelf = new Bookshelf();
    }

    @Test
    public void testAddBookAddOneBookNoReplica(){
        assertTrue(bookshelf.add("LOL", "Eric", "art",2018));
    }

    @Test
    public void testAddBookAddTwoBooksOneReplica(){
        assertTrue(bookshelf.add("BNW", "Huxley", "fiction", 1932));
        assertFalse(bookshelf.add("BNW", "Huxley", "fiction",1932));
    }

    @Test
    public void testReplicaCheckNoIdenticalField(){
        bookshelf.add("HP","JKR","fiction",2017);
        Book testBook = new Book("Special Relativity","AE","uncategorized",1915);
        assertTrue(bookshelf.replicaCheck(testBook));
    }

    @Test
    public void testReplicaCheckNotIdenticalName(){
        bookshelf.add("HP","JKR","fiction",2017);
        Book testBook = new Book("FB","JKR","fiction",2017);
        assertTrue(bookshelf.replicaCheck(testBook));
    }

    @Test
    public void testReplicaCheckNotIdenticalAuthor(){
        bookshelf.add("HP","JKR","fiction",2017);
        Book testBook = new Book("HP","ABC","fiction",2017);
        assertTrue(bookshelf.replicaCheck(testBook));
    }

    @Test
    public void testReplicaCheckNotIdenticalGenre(){
        bookshelf.add("HP","JKR","fiction",2017);
        Book testBook = new Book("HP","JKR","biography",2017);
        assertTrue(bookshelf.replicaCheck(testBook));
    }

    @Test
    public void testReplicaCheckNotIdenticalYearOfPublish(){
        bookshelf.add("HP","JKR","fiction",2017);
        Book testBook = new Book("HP","JKR","fiction",2015);
    }

    @Test
    public void testReplicaCheckOneReplica(){
        bookshelf.add("HP","JKR","fiction",2017);
        Book testBook = new Book("HP","JKR","fiction",2017);
        assertFalse(bookshelf.replicaCheck(testBook));
    }

    @Test
    public void testScanFromFileAddOneFile(){
        bookshelf.scanFromFile("src/testIOFiles/testScanFromFileAddOneFile.txt");
        assertFalse(bookshelf.add("Special Relativity","Joe","uncategorized",2000));
        assertFalse(bookshelf.add("How to Play League Right","Bill","biography",2014));
        assertFalse(bookshelf.add("Reddit it","Jemma","fiction",2012));
    }
}
