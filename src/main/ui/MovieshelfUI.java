package ui;

import model.Movieshelf;

import java.util.Observable;

public class MovieshelfUI extends ModuleUI {
    private Movieshelf movieshelf;

    // constructors
    public MovieshelfUI (Movieshelf ms){
        super();
        movieshelf = ms;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
