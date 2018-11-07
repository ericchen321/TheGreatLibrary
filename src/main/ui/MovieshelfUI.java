package ui;

import model.Movieshelf;
import ui.operations.*;

public class MovieshelfUI extends ShelfUI{
    private Movieshelf movieshelf;

    // constructors
    public MovieshelfUI (Movieshelf ms){
        movieshelf = ms;
    }

    // MODIFIES: this
    // EFFECTS: adds all available operations to the movieshelf
    //          and adds each operation's button to the movieshelf's panel
    public void addOperations() {
        Operation importMovieOp = new ImportMoviesOperation();
        operations.add(importMovieOp);
        this.panel.add(importMovieOp.getButton());
        Operation importMovieEdOp = new ImportMovieEdOperation(movieshelf);
        operations.add(importMovieEdOp);
        this.panel.add(importMovieEdOp.getButton());
    }
}
