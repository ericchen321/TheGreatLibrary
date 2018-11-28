package ui;

import model.Artwork;
import model.Book;
import model.Bookshelf;
import ui.operations.RefreshOperation;

import java.util.ArrayList;
import java.util.Observable;

public class BookshelfUI extends ShelfUI {

    // constructors
    public BookshelfUI(Bookshelf bookshelf){
        super(bookshelf);
        resetInfoDisplayAreaContent();
    }

    @Override
    // MODIFIES: this
    // EFFECTS: if an RefreshOperation sends the message
    //          then updates browsing area's content AND tell
    //          user content is refreshed if activeModule is
    //          of Bookshelf type
    public void update(Observable o, Object activeModule) {
        if (o instanceof RefreshOperation && activeModule instanceof Bookshelf){
            super.updateBrowsingArea();
        }
    }

    // TODO: extract a method from here for behaviors also existing in MovieshelfUI
    @Override
    protected Artwork buildArtworkFromString(String workString) {
        workString = workString.substring(6, workString.length()-8);
        ArrayList<String> workInfo = splitOnBreakLine(workString);
        String workName = workInfo.get(0);
        String authorName = workInfo.get(1);
        return new Book(workName, authorName, 0);
    }
}
