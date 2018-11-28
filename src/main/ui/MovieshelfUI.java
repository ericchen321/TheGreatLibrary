package ui;

import model.Artwork;
import model.Movie;
import model.Movieshelf;
import ui.operations.RefreshOperation;

import java.util.ArrayList;
import java.util.Observable;

public class MovieshelfUI extends ShelfUI {

    // constructors
    public MovieshelfUI (Movieshelf movieshelf){
        super(movieshelf);
    }

    @Override
    // MODIFIES: this
    // EFFECTS: if an RefreshOperation sends the message
    //          update browsing area's content AND tell
    //          user content is refreshed if activeModule is
    //          of Movieshelf type
    public void update(Observable o, Object activeModule) {
        if (o instanceof RefreshOperation && activeModule instanceof Movieshelf){
            super.updateBrowsingArea();
        }
    }

    @Override
    protected Artwork buildArtworkFromString(String workString) {
        workString = workString.substring(6, workString.length()-8);
        ArrayList<String> workInfo = splitOnBreakLine(workString);
        String workName = workInfo.get(0);
        String authorName = workInfo.get(1);
        return new Movie(workName, authorName, 0);
    }
}
