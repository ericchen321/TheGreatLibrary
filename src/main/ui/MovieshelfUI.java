package ui;

import model.Bookshelf;
import model.Movieshelf;

import java.util.Observable;

public class MovieshelfUI extends ShelfUI {

    // constructors
    public MovieshelfUI (Movieshelf movieshelf){
        super(movieshelf);
        initializeInfoDisplayAreaContent();
    }

    @Override
    // MODIFIES: this
    // EFFECTS: update browsing area's content AND tell
    //          user content is refreshed if activeModule is
    //          of Movieshelf type
    public void update(Observable o, Object activeModule) {
        if (activeModule instanceof Movieshelf){
            super.updateBrowsingArea();
        }
    }
}
