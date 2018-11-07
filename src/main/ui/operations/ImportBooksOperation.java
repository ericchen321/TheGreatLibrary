package ui.operations;

import model.Bookshelf;

import java.awt.event.ActionEvent;

public class ImportBooksOperation extends ImportArtworksOperation{

    // constructors
    // MODIFIES: this
    // EFFECTS: creates a button for this operation;
    //          initialize the button's appearance;
    //          set up behavior when the button is clicked
    public ImportBooksOperation(Bookshelf bs){
        super(bs, "book");
    }

    // MODIFIES: this
    // EFFECTS: set action when button for this operation is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        shelf.loadFromFile("input-books.txt");
        System.out.println("Books imported!");
    }

}
