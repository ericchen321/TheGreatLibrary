package ui.operations;

import model.Bookshelf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportBooksOperation extends Operation implements ActionListener{
    private Bookshelf bookshelf;

    // constructors
    public ImportBooksOperation(Bookshelf bs){
        this.bookshelf = bs;
        createButton("Import Books");
        initializeButtonAppearance();
        button.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: set action when button for this operation is clicked
    public void actionPerformed(ActionEvent e) {
        bookshelf.loadFromFile("input-books.txt");
        System.out.println("Books imported!");
    }

}
