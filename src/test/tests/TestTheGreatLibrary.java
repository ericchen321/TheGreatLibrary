package tests;

import model.Book;
import org.junit.jupiter.api.BeforeEach;
import ui.TheGreatLibrary;
import org.junit.jupiter.api.Test;

public class TestTheGreatLibrary {
    private TheGreatLibrary TGLapp;

    @BeforeEach
    public void setUp(){
        TGLapp = new TheGreatLibrary();
    }
}
