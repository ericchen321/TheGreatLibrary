package ui;

import model.Movieshelf;

import java.util.Observable;

public class MovieshelfUI extends ShelfUI {

    // constructors
    public MovieshelfUI (Movieshelf movieshelf){
        super(movieshelf);
        initializeInfoDisplayAreaContent();
    }
}
