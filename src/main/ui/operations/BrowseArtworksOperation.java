package ui.operations;

import model.Bookshelf;
import model.Shelf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class BrowseArtworksOperation extends Operation implements ActionListener{
    protected Shelf shelf;

    // constructors
    // MODIFIES: this
    // EFFECTS: creates a button for this operation;
    //          initialize the button's appearance;
    //          set up behavior when the button is clicked
    public BrowseArtworksOperation(Shelf s){
        shelf = s;
        createButton("Browse " + ((s instanceof Bookshelf)? "books":"movies"));
        //initializeButtonAppearance();
        button.addActionListener(this);
    }

    @Override
    public abstract void actionPerformed(ActionEvent e);
}
