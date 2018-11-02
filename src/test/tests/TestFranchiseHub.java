package tests;

import model.Book;
import model.FranchiseHub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFranchiseHub {
    private FranchiseHub franchiseHub;

    @BeforeEach
    public void setUp(){
        franchiseHub = new FranchiseHub();
    }

    @Test
    public void testAddToFranchise() {
        Book book1 = new Book("A Game of Thrones", "GM");
        Book book2 = new Book("A Clash of Kings", "GM");

        franchiseHub.addToFranchise("A Song of Ice and Fire", book1);
        franchiseHub.addToFranchise("A Song of Ice and Fire", book2);
        assertEquals(2, franchiseHub.getWorkSize("A Song of Ice and Fire"));
        assertTrue(franchiseHub.searchWork("A Song of Ice and Fire", book1));
        assertTrue(franchiseHub.searchWork("A Song of Ice and Fire", book2));
    }
}
