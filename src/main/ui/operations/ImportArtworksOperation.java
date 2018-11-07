package ui.operations;

import model.Shelf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ImportArtworksOperation extends Operation implements ActionListener{
    protected Shelf shelf;

    // constructors
    // MODIFIES: this
    // EFFECTS: creates a button for this operation;
    //          initialize the button's appearance;
    //          set up behavior when the button is clicked
    public ImportArtworksOperation(Shelf s, String type){
        shelf = s;
        createButton("Import " + type + "s");
        initializeButtonAppearance();
        button.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: set action when button for this operation is clicked
    public abstract void actionPerformed(ActionEvent e);
}
