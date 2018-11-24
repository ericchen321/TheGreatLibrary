package ui;

import model.Bookshelf;
import model.Movieshelf;

import java.awt.event.ActionEvent;

public class FranchiseHubUI extends ModuleUI {
    private Bookshelf bookshelf;
    private Movieshelf movieshelf;

    // constructors
    public FranchiseHubUI(Bookshelf bs, Movieshelf ms){
        super();
        bookshelf = bs;
        movieshelf = ms;
    }
}
