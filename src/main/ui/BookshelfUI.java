package ui;

import model.Bookshelf;
import model.Module;

import java.util.Observable;

public class BookshelfUI extends ShelfUI {

    // constructors
    public BookshelfUI(Bookshelf bookshelf){
        super(bookshelf);
        initializeInfoDisplayAreaContent();
    }

    @Override
    // MODIFIES: this
    // EFFECTS: update browsing area's content AND tell
    //          user content is refreshed if activeModule is
    //          of Bookshelf type
    public void update(Observable o, Object activeModule) {
        if (activeModule instanceof Bookshelf){
            super.updateBrowsingArea();
        }
    }

}
