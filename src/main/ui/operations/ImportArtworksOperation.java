package ui.operations;

import model.Bookshelf;
import model.Movieshelf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportArtworksOperation extends Operation implements ActionListener{

    // constructors
    // MODIFIES: this
    // EFFECTS: creates a button for this operation;
    //          initialize the button's appearance;
    //          set up behavior when the button is clicked
    public ImportArtworksOperation(){
        createButton("Import");
        initializeButtonAppearance("/imgs/import.png"); // REFERENCE: icon image by Kirill Kazachek from www.flaticon.com
        button.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: set action when button for this operation is clicked
    public void actionPerformed(ActionEvent e){
        if (activeModule instanceof Bookshelf){
            ((Bookshelf) activeModule).loadFromFile("input-books.txt",((Bookshelf) activeModule));
            System.out.println("Books imported!");
        }
        else if (activeModule instanceof Movieshelf){
            ((Movieshelf) activeModule).loadFromFile("input-movies.txt", ((Movieshelf) activeModule));
            System.out.println("Movies imported!");
        }
        else {
            System.out.println("Operation not supported!");
        }
    }
}
