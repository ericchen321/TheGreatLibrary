package ui.operations;

import model.Bookshelf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportBooksOperation extends Operation {
    // action listener class for button of this operation
    private class ImportBookActionListener implements ActionListener {
        Bookshelf bookshelf;

        public ImportBookActionListener(Bookshelf bookshelf) {
            this.bookshelf = bookshelf;
        }

        public void actionPerformed(ActionEvent e) {
            bookshelf.loadFromFile("input-books.txt");
            System.out.println("Books imported!");
        }
    }

    // constructors
    public ImportBooksOperation(Bookshelf bookshelf){
        createButton("Import Books");
        initializeButtonAppearance();
        setButtonAction(bookshelf);
    }

    // MODIFIES: this
    // EFFECTS: set action when button for this operation is clicked
    private void setButtonAction(Bookshelf bookshelf){
        ImportBookActionListener buttonAL = new ImportBookActionListener(bookshelf);
        button.addActionListener(buttonAL);
    }

}
