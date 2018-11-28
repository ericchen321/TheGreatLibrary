package ui.operations;

import model.Bookshelf;
import model.Movieshelf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExportArtworksOperation extends Operation implements ActionListener {

    // constructors
    // MODIFIES: this
    // EFFECTS: creates a button for this operation;
    //          initialize the button's appearance;
    //          set up behavior when the button is clicked
    public ExportArtworksOperation(){
        createButton("Export");
        initializeButtonAppearance("/imgs/export-by-geotatah.png"); // REFERENCE: icon image by geotatah from www.flaticon.com
        button.addActionListener(this);
    }

    @Override
    // MODIFIES: this
    // EFFECTS: set action when button for this operation is clicked
    public void actionPerformed(ActionEvent e){
        if (activeModule instanceof Bookshelf){
            ((Bookshelf) activeModule).printToFile("output-books.txt");
            System.out.println("Books exported!");
        }
        else if (activeModule instanceof Movieshelf){
            ((Movieshelf) activeModule).printToFile("output-movies.txt");
            System.out.println("Movies exported!");
        }
        else {
            System.out.println("Operation not supported!");
        }
    }
}
