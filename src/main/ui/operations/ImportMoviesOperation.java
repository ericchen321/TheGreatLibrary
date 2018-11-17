package ui.operations;

import model.Movieshelf;

import java.awt.event.ActionEvent;

public class ImportMoviesOperation extends ImportArtworksOperation {

    // constructors
    // MODIFIES: this
    // EFFECTS: creates a button for this operation;
    //          initialize the button's appearance;
    //          set up behavior when the button is clicked
    public ImportMoviesOperation(Movieshelf ms){
        super(ms, "movie");
    }

    // MODIFIES: this
    // EFFECTS: set action when button for this operation is clicked
    public void actionPerformed(ActionEvent e) {
        shelf.loadFromFile("input-movies.txt", shelf);
        System.out.println("Movies imported!");
    }
}
